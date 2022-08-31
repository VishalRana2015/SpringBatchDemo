<h3> InitializingBean </h3>
Method of this interface is called once SpringBoot initializes the bean. See CustomTasklet
<pre>
2022-09-01 00:31:27.641  INFO 9556 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
serviceClass is not null
CustomTasklet constructor called.
CustomTasklet's afterPropertiesSet method called.
serviceClass is not null
CustomTasklet constructor called.
2022-09-01 00:31:28.055  WARN 9556 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2022-09-01 00:31:28.759  WARN 9556 --- [           main] o.s.b.a.batch.JpaBatchConfigurer         : JPA does not support custom isolation levels, so locks may not be taken when launching Jobs. To silence this warning, set 'spring.batch.jdbc.isolation-level-for-create' to 'default'.
2022-09-01 00:31:28.767  INFO 9556 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: POSTGRES
</pre>