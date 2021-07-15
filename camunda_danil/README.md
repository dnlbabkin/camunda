# Бизнес-процесс "MyProcessExample"

Реализован бизнес-процесс, в котором описаны две переменные и одна HumanTask. Бизнес-процесс запускается посредством API:
>localhost:8080/camunda/rest-api/startProcess/{key}

Метод запуска процесса:
```
@Bean
    public void startService(String key){
        ProcessEngine processEngines =  ProcessEngines.getDefaultProcessEngine();

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("source", "api");
        processEngines.getRuntimeService().startProcessInstanceByKey(key, variables);
    }
```
Для предоставления доступа к самому процессу отвечают:
```
ProcessEngine processEngines = ProcessEngines.getDefaultProcessEngine();
```
И
```
processEngines.getRuntimeService().startProcessInstanceByKey(key, variables);
```
В фрагменте
```
 Map<String, Object> variables = new HashMap<String, Object>();
 variables.put("source", "api");
```
Устаналиваются HashMap значения, т.к. при запуске процесса с API переменная source должна принимать значение "api".

Был осуществлен RestController, т.е. класс, в котором осуществляется вся логика обработки клиентских запросов:
```
@RestController
public class StartProcessController {
    StartProcess startProcess = new StartProcess();

    @GetMapping(value = "/camunda/rest-api/startProcess/{key}", produces = "application/json")
    public ResponseEntity<?> startService(@PathVariable String key){
        startProcess.startService(key);

        return new ResponseEntity<>(startProcess.toString(), HttpStatus.CREATED);
    }
}
```
В аннотации:
```
 @GetMapping(value = "/camunda/rest-api/startProcess/{key}", produces = "application/json")
```
Обозначается, что метод обрабатывает GET запрос по адресу camunda/rest-api/startProcess/{key}, где key - это id запускаемого процесса.

###Замена значений переменной при разном варианте запуска процесса

Значение переменной source меняется в зависимости от того, как был запущен бизнес-процесс. Если запуск осуществляется со стороны API, то переменная имеет значение "api", если процесс запуска осуществляется с админки, то и процесс соответственно принимает значение "adminka".

Выглядит реализация следующим образом:
```
public class StartProcessDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        try {
            if (execution.getVariable("source").equals("api")) {
                execution.setVariable("source", "api");
            }
        } catch (Exception e){
                execution.setVariable("source", "adminka");
        }
    }
}
```
В UserTask процессе устанавливается ExecutionL Listener в который делегируется класс "StartProcessDelegate". Во время выполнения процесса в классе происходит проверка на исходное значение переменной source, в случае когда значение, стоящее по умолчанию, равно значению "api", то source равен "api". В противном случае отлавливается Execution и значение source обретает значение "adminka".

##Создание API для запуска 50 процессов TeamA и 50 процессов TeamB

API использует POST запрос, который запускает 50 бизнес-процессов Team A и 50 запросов Team B
>localhost:8080/camunda/rest-api/processes

##Создание API для подсчета количества мужчин и женщин в TeamX процессе

API использует GET запрос, параметр которого проверяет выбранный процесс и из выбранного процесса проверяет и считает количество мужчин и женщин.

>localhost:8080/camunda/rest-api/calc?team=TeamX

Где X TeamA или TeamB
