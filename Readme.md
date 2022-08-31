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

Job: [SimpleJob: [name=job1]] launched with the following parameters: [{name=Launch3}]
2022-08-31 15:59:41.112  INFO 37352 --- [nio-8080-exec-2] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step1]
Returning : item 1
Returning : item 2
CustomItemWriter's write method called
item 1processed
item 2processed

Returning : item 3
Returning : item 4
CustomItemWriter's write method called
item 3processed
item 4processed

Returning : item 5
Returning : item 6
CustomItemWriter's write method called
item 5processed
item 6processed

Returning : item 7
Returning : item 8
CustomItemWriter's write method called
item 7processed
item 8processed

Returning : item 9
Returning : item 10
CustomItemWriter's write method called
item 9processed
item 10processed

2022-08-31 15:59:41.178  INFO 37352 --- [nio-8080-exec-2] o.s.batch.core.step.AbstractStep         : Step: [step1] executed in 64ms
2022-08-31 15:59:41.190  INFO 37352 --- [nio-8080-exec-2] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=job1]] completed with the following parameters: [{name=Launch3}] and the following status: 