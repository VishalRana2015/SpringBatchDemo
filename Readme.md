This project demonstrate Spring Batch
How to make use SimpleJob. <br/>
First understand the logic written in Simple Job, you will be able to see what does it do, and how to configure various steps.<br/><br/>
Here is what we found<br/>
* SimpleJob maintains a List of Steps. 
* You can add more step using <b>addStep(Step step)</b>
* You can set steps using <b>setSteps( List<Step> steps)</b>
* <b> SimpleJob(String name)</b> and <b>SimpleJob()</b> are two constructors available.
* And there is method <b>doExecute(JobExecution execution)</b> which executes all the steps. It calls each step one by one and if any steps fails, jobExecution fails.

First of all we don't know how to get JobExecution. 
jobLauncher.run( job, jobparameters) // this is how we run a job.