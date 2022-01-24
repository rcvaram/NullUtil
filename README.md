https://search.maven.org/artifact/io.github.rcvaram/NullUtil/1.0/jar

### Maven Depedency
```
<dependency>
   <groupId>io.github.rcvaram</groupId
   <artifactId>NullUtil</artifactId>
   <version>1.0</version>
</dependency>
```

### Gradle Depedency 
```
implementation 'io.github.rcvaram:NullUtil:1.0'
```


## Information

1. NullUtil.executeViaNullSafer method will execute the given function on Non-Null Values and, when the value is null It will return Null instead of executing the function.
2. NullUtil.executeExecutorOrDefault method will execute the given function on Non-Null Values and, If the value is null, It will return the given default value.
3. NullUtil.executeMutator method mutates the reference type values without returning anything. If the value is null, It will not do anything.
4. NullUtil.replaceNull method will replace the null value with the given defaultValue. when the value is not null, It will return the value.
5. NullUtil.hasText method is used to check the String value has any kind of text or not.
6. NullUtil.trimValue method will be used to trim the String without causing the null pointer Exception.


More details about this Util class you can find on my medium article(https://rcvaram.medium.com/remove-dirty-nullchecks-in-java-8aca833dc276) or my stackoverflow answer(https://stackoverflow.com/a/70200959/12894468).
