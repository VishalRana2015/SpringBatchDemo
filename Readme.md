Demonstration of <b>startLimit and allowStartIfComplete</b> <br/>

We have configured the step to run even though if its BatchStatus is COMPLETE in the previous execution of the same job instance.
By default, it skips the steps which are already COMPLETED and thus doesn't create any StepExecution for that particular Step.<br/><br/>
Invoke the job with parameter 'name=Launch1' <br/>
Then invoke again<br/>
and again<br/>
Here you will get error.<br/>
startLimit(2)<br/>
allowStartIfComplete(true)<br/><br/>

There are two ways the mark the job as 'FAILED'.
1. Mark the corresponding JobExecution's status as 'FAILED' by manually editing the entry in the database.
2. Registering a JobExecutionListener with the Job and then overriding the 'afterJob' method of that JobListener to return jobExecution with status of BatchStatus.FAILED.

In this demonstration we have chosen the second way.