# Stock Hawk Udacity Project-3

This Android App is the Udacity Nanodegree project-3 Stock Hawk. This application uses the yahoo API of stocks and giving ability to view the stocks and other core  functionlity that help to visualize the stock . This project following the [Ribot](https://github.com/ribot/android-guidelines) guide lines.

##Screenshots
<table>
  <tr>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Stock-Hawk/master/screenshots/s1.png"></td>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Stock-Hawk/master/screenshots/s2.png"></td>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Stock-Hawk/master/screenshots/s3.png"></td>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Stock-Hawk/master/screenshots/s5.png"></td>
    <td><img src="https://raw.githubusercontent.com/therajanmaurya/Stock-Hawk/master/screenshots/s4.png"></td>
  </tr>
</table>

Libraries and tools included:

- Support libraries
- RecyclerViews and CardViews 
- [RxJava](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid) 
- [Retrofit 2](http://square.github.io/retrofit/)
- [Dagger 2](http://google.github.io/dagger/)
- [SqlBrite](https://github.com/square/sqlbrite)
- [Butterknife](https://github.com/JakeWharton/butterknife)
- [Timber](https://github.com/JakeWharton/timber)
- [Glide](https://github.com/bumptech/glide)
- Functional tests with [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/index.html)
- [Robolectric](http://robolectric.org/)
- [Mockito](http://mockito.org/)
- [Checkstyle](http://checkstyle.sourceforge.net/), [PMD](https://pmd.github.io/) and [Findbugs](http://findbugs.sourceforge.net/) for code analysis

## Requirements

- JDK 1.8
- [Android SDK](http://developer.android.com/sdk/index.html).
- Android N [(API 24) ](http://developer.android.com/tools/revisions/platforms.html).
- Latest Android SDK Tools and build tools.

## Contributing

If you would like to contribute to Stock Hawk, the [contributing guide](https://github.com/therajanmaurya/Stock-Hawk/blob/master/CONTRIBUTING.md) is a good place to start. If you have questions, feel free to ask.

## Architecture

This project follows ribot's Android architecture guidelines that are based on [MVP (Model View Presenter)](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter). Read more about them [here](https://github.com/ribot/android-guidelines/blob/master/architecture_guidelines/android_architecture.md). 

![](https://github.com/ribot/android-guidelines/raw/master/architecture_guidelines/architecture_diagram.png)

## Code Quality

This project integrates a combination of unit tests, functional test and code analysis tools. 

### Tests

To run **unit** tests on your machine:

``` 
./gradlew test
``` 

To run **functional** tests on connected devices:

``` 
./gradlew connectedAndroidTest
``` 

Note: For Android Studio to use syntax highlighting for Automated tests and Unit tests you **must** switch the Build Variant to the desired mode.

### Code Analysis tools 

The following code analysis tools are set up on this project:

* [PMD](https://pmd.github.io/): It finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. See [this project's PMD ruleset](config/quality/pmd/pmd-ruleset.xml).

``` 
./gradlew pmd
```

* [Findbugs](http://findbugs.sourceforge.net/): This tool uses static analysis to find bugs in Java code. Unlike PMD, it uses compiled Java bytecode instead of source code.

```
./gradlew findbugs
```

* [Checkstyle](http://checkstyle.sourceforge.net/): It ensures that the code style follows [our Android code guidelines](https://github.com/ribot/android-guidelines/blob/master/project_and_code_guidelines.md#2-code-guidelines). See our [checkstyle config file](config/quality/checkstyle/checkstyle-config.xml).

```
./gradlew checkstyle
```

### The check task

To ensure that your code is valid and stable use check: 

```
./gradlew check
```

This will run all the code analysis tools and unit tests in the following order:

![Check Diagram](images/check-task-diagram.png)
 
## Distribution

The project can be distributed using either [Crashlytics](http://support.crashlytics.com/knowledgebase/articles/388925-beta-distributions-with-gradle) or the [Google Play Store](https://github.com/Triple-T/gradle-play-publisher).

### Play Store

We use the __Gradle Play Publisher__ plugin. Once set up correctly, you will be able to push new builds to
the Alpha, Beta or production channels like this

```
./gradlew publishApkRelease
```
Read [plugin documentation](https://github.com/Triple-T/gradle-play-publisher) for more info.

### Crashlytics

You can also use Fabric's Crashlytics for distributing beta releases. Remember to add your fabric
account details to `app/src/fabric.properties`.

To upload a release build to Crashlytics run:

```
./gradlew assembleRelease crashlyticsUploadDistributionRelease
```
