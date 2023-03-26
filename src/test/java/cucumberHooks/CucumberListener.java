package cucumberHooks;


import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

public class CucumberListener implements EventListener {
    public static int count_totalTCs;
    public static int count_passedTCs;
    public static int count_skippedTCs;
    public static int count_failedTCs;

    public CucumberListener() {
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        /*
         * :: is method reference , so this::collecTag means collectTags method in
         * 'this' instance. Here we says runStarted method accepts or listens to
         * TestRunStarted event type
         */
        publisher.registerHandlerFor(TestRunStarted.class, this::runStarted);
        publisher.registerHandlerFor(TestRunFinished.class, this::runFinished);
        publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
        publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::ScenarioFinished);
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
    }

    /*
     * Here we set argument type as TestRunStarted if you set anything else then the
     * corresponding register shows error as it doesn't have a listner method that
     * accepts the type specified in TestRunStarted.class
     */

    // Here we create the reporter
    private void runStarted(TestRunStarted event) {
    }

    // TestRunFinished event is triggered when all feature file executions are completed
    private void runFinished(TestRunFinished event) {
    }

    // This event is triggered when feature file is read
    // here we create the feature node
    private void featureRead(TestSourceRead event) {
    }

    // This event is triggered when Test Case is started
    // here we create the scenario node
    private void ScenarioStarted(TestCaseStarted event) {
        count_totalTCs = count_totalTCs + 1;
    }

    private void ScenarioFinished(TestCaseFinished event) {
        if (event.getResult().getStatus().toString() == "PASSED") {
            count_passedTCs = count_passedTCs + 1;
        } else if (event.getResult().getStatus().toString() == "SKIPPED") {
            count_skippedTCs = count_skippedTCs + 1;
        } else {
            count_failedTCs = count_failedTCs + 1;
        }
    }

    private void stepStarted(TestStepStarted event) {
    }

    private void stepFinished(TestStepFinished event) {

    }

}
