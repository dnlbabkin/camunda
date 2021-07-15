package com.example.workflow.requsetVacationShedule;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.camunda.bpm.engine.history.HistoricVariableInstance;

import java.util.Date;
import java.util.List;

public class dataValidation implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();
        IdentityService identityService = processEngine.getIdentityService();

        final long current = 86400000;
        final int allDays = 28;

        String typeOfVacation = (String) execution.getVariable("Vacation_type");
        execution.setVariable("APP", "APP1");
        execution.setVariable("status", "Value_2qn8jsq");

        Date startDate = null;
        Date endDate = null;

        int daysAreBlocked = 0;
        String APP = "APP1";
        String user = "";
        String status = "";

        Date vacationBegin = (Date) execution.getVariable("Vacation_begin");
        Date vacationEnd = (Date) execution.getVariable("Vacation_end");

        if (vacationBegin == null || vacationEnd == null) {
            throw new Exception("Данные не введены");
        }

        int daysUntil = (int) ((vacationEnd.getTime() - vacationBegin.getTime()) / current);
        int daysUsed = 0;

        if (vacationEnd.getTime() < vacationBegin.getTime()) {
            throw new Exception("Дата начала отпуска больше даты конца.");
        }

        if (typeOfVacation.equals("Value_0ie87ok") && daysUntil < 14) {
            throw new Exception("Минимальное количество дней для такого отпуска - 14.");
        }

        if (typeOfVacation.equals("Value_2cpv0s6") && daysUntil > 3) {
            throw new Exception("Максимальное количество дней для такого отпуска - 3.");
        }

        List<HistoricTaskInstance> tasks = historyService.createHistoricTaskInstanceQuery().finished().processDefinitionKey("request_vacation_shedule").list();

        for (HistoricTaskInstance task : tasks) {
            List<HistoricVariableInstance> tasksVars = historyService.createHistoricVariableInstanceQuery().processInstanceId(task.getProcessInstanceId()).list();

            for (HistoricVariableInstance var : tasksVars) {
                if (var.getName().equals("vacation_begin")) {
                    vacationBegin = (Date) var.getValue();
                }
                if (var.getName().equals("vacation_end")) {
                    vacationEnd = (Date) var.getValue();
                }
                if (var.getName().equals("APP")) {
                    APP = (String) var.getValue();
                }
                if (var.getName().equals("start")) {
                    user = (String) var.getValue();
                }
                if (var.getName().equals("status")) {
                    status = (String) var.getValue();
                }
            }

            if (status.equals("Value_2ppf91u")) {
                daysAreBlocked += (int) ((vacationEnd.getTime() - vacationBegin.getTime()) / current);
            }

            if (vacationBegin != null && vacationEnd != null && user.equals(identityService.getCurrentAuthentication().getUserId()) && status.equals("Value_2qn8jsq")) {
                daysUsed += (int) ((vacationEnd.getTime() - vacationBegin.getTime()) / current);

                if (daysUsed + daysAreBlocked < 28 && daysUsed + daysAreBlocked + daysUntil > 28) {
                    throw new Exception(user + " осталось только " + (28 - daysAreBlocked - daysUsed) + " дней отпуска.");
                }

                if (daysUntil > 28 && typeOfVacation.equals("Value_0ie87ok")) {
                    throw new Exception("Превышено общее количество дней отпуска на : " + (daysUntil - (28 - daysUsed)));
                }

                if (daysUsed > 28 || daysAreBlocked > 28) {
                    throw new Exception("Ошибка," + user + " исользовали все дни");
                }

                if (!APP.equals("") || APP != null) {
                    execution.setVariable("APP", "APP" + (Integer.parseInt(APP.substring(3, APP.length())) + 1));
                }
            } else {
                startDate = null;
                endDate = null;

                continue;
            }

            if (vacationBegin.getTime() <= vacationBegin.getTime() && vacationEnd.getTime() >= vacationBegin.getTime() || vacationEnd.getTime() <= vacationEnd.getTime() && vacationEnd.getTime() >= vacationEnd.getTime()) {
                throw new Exception("Уже существует заявка на указанный период отпуска. Пожалуйста, исправьте сроки");
            }

            startDate = null;
            endDate = null;
        }
    }
}
