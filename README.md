# Проект по автоматизации тестовых сценариев для компании <p align="center"><a href = "https://www.litres.ru"><img src="media/logo/Litres-logo.png" width="500" title="Litres"></a></p>
> Компания ЛитРес, основанная в 2005 году, сегодня является лидером на рынке лицензионных электронных книг в России и странах СНГ.
>
## :scroll: Содержание:

* <a href="#tools">Использованный стек технологий</a>
* <a href="#launch">Запуск автотестов</a>
* <a href="#build">Сборка в Jenkins</a>
* <a href="#allure">Пример Allure-отчета</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#notifications">Уведомления в Telegram с использованием бота</a>
* <a href="#video">Видео примера запуска тестов в Selenoid</a>

<a id="tools"></a>
## <a name="Использованный стек технологий"> :computer: **Использованный стек технологий** </a>

<p align="center">
<a href="https://www.jetbrains.com/idea/" target="_blank"><img width="6%" title="IntelliJ IDEA" src="media/icons/IntelijIdea.svg" alt=""></a>
<a href="https://www.java.com/ru/" target="_blank"><img width="6%" title="Java" src="media/icons/Java.svg" alt=""></a>
<a href="https://selenide.org/" target="_blank"><img width="6%" title="Selenide" src="media/icons/Selenide.svg" alt=""></a>
<a href="https://aerokube.com/selenoid/" target="_blank"><img width="6%" title="Selenoid" src="media/icons/Selenoid.svg" alt=""></a>
<a href="https://allurereport.org/" target="_blank"><img width="6%" title="Allure Report" src="media/icons/AllureReport.svg" alt=""></a>
<a href="https://qameta.io/" target="_blank"><img width="5%" title="Allure TestOps" src="media/icons/AllureTestOps.svg" alt=""></a>
<a href="https://gradle.org/" target="_blank"><img width="6%" title="Gradle" src="media/icons/Gradle.svg" alt=""></a>
<a href="https://junit.org/junit5/" target="_blank"><img width="6%" title="JUnit5" src="media/icons/JUnit5.svg" alt=""></a>
<a href="https://github.com/" target="_blank"><img width="6%" title="GitHub" src="media/icons/Github.svg" alt=""></a>
<a href="https://www.jenkins.io/" target="_blank"><img width="6%" title="Jenkins" src="media/icons/Jenkins.svg" alt=""></a>
<a href="https://telegram.org/" target="_blank"><img width="6%" title="Telegram" src="media/icons/Telegram.svg" alt=""></a>
<a href="https://www.atlassian.com/ru/software/jira" target="_blank"><img width="5%" title="Jira" src="media/icons/Jira.svg" alt=""></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>Selenide</code> и <code>Rest-Assured</code> для API взаимодействий;
- В качестве сборщика проекта был использован - <code>Gradle</code>;
- Использованы фреймворки: <code>JUnit 5</code> и [Selenide](https://selenide.org/);
- При прогоне тестов браузер запускается в [Selenoid](https://selenoid.autotests.cloud/);
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов прогона в <code>Telegram</code> при помощи бота;
- Реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>

### Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста

<a id="launch"></a>
## <a name="Запуск автотестов"> :arrow_forward: **Запуск автотестов** </a>

### Запуск тестов из терминала
```
gradle clean test
```
После выполнения команды, автотесты запускаются удаленно в <code>Selenoid</code>.

### Запуск тестов на удаленном браузере
```
gradle clean test -Denv=main
```
### При необходимости также можно переопределить параметры запуска:

```
clean test -Dtype=${TAG}
"-Dbrowser=${BROWSER}"
"-DbrowserVersion=${BROWSER_VERSION}"
"-DwindowSize=${WINDOW_SIZE}"
"-Dselenide.remote=https://${AUTH}@${REMOTE_URL}/wd/hub"
```
### Параметры сборки

* <code>TAG</code> – запуск автотестов по определенному тегу, которым они отмечены. По-умолчанию - <code>smoke</code>, который запускает все автотесты;
* <code>BROWSER</code> – браузер, в котором будут запускаться автотесты. По-умолчанию - <code>chrome</code>;
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут запускаться автотесты. По-умолчанию - <code>122.0</code>;
* <code>WINDOW_SIZE</code> – размер окна браузера, в котором будут запускаться автотесты. По-умолчанию - <code>1920x1080</code>;
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться автотесты
<a id="build"></a>
## <a href="https://jenkins.autotests.cloud/job/LITRES_PROJECT/" target="_blank" name="Сборка в Jenkins"><img src="media/icons/Jenkins.svg" title="Jenkins" width="4%"/> **Сборка в Jenkins** </a>
<p align="center">
<img title="Jenkins Build" src="media/screenshots/Jenkins.png" alt="">
</p>

<a id="allure"></a>
## <a href="https://jenkins.autotests.cloud/job/LITRES_PROJECT/21/allure/#suites/22c6e3f9c7ca7eb8a4821fa801aeb0eb/66c0ab83c36eea29/" target="_blank" name="Пример Allure-отчета"><img src="media/icons/AllureReport.svg" title="Allure Report" width="4%"/> **Пример Allure-отчета** </a>
### Overview

<p align="center">
<img title="Allure Overview" src="media/screenshots/AllureReport-1.png" alt="">
</p>

### Результат выполнения теста

<p align="center">
<img title="Test Results in Allure" src="media/screenshots/AllureReport-2.png" alt="">
</p>

<a id="testops"></a>
## <a name="Интеграция с Allure TestOps"><img src="media/icons/AllureTestOps.svg" width="4%"/> **Интеграция с Allure TestOps** </a>

- Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>;
- Результат выполнения автотестов отображается в <code>Allure TestOps</code>;
- На <code>Dashboard</code> в <code>Allure TestOps</code> отображена статистика пройденных тестов

<p align="center">
<img title="Allure TestOps Dashboard" src="media/screenshots/AllureTestOps.png" alt="">
</p>

<a id="jira"></a>
## <a name="Интеграция с Jira"><img src="media/icons/Jira.svg" title="Jira" width="4%"/> **Интеграция с Jira** </a>

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие именно тест-кейсы были реализованы в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/screenshots/Jira-1.png" alt="">
</p>

<p align="center">
<img title="Jira Task" src="media/screenshots/Jira-2.png" alt="">
</p>

<a id="notifications"></a>
## <a name="Уведомления в Telegram с использованием бота"><img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> **Уведомления в Telegram с использованием бота** </a>

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом прогона.

<p align="center">
<img width="840" title="Telegram Notifications" src="media/screenshots/TelegramNotification.png" alt="">
</p>

<a id="video"></a>
## <a name="Видео примера запуска тестов в Selenoid"><img src="media/icons/Selenoid.svg" title="Jira" width="4%"/> **Видео примера запуска тестов в Selenoid** </a>

К каждому автотесту в Allure-отчете сохраняется видео запуска автотеста после его завершения.
<p align="center">
  <img title="Selenoid Video" src="media/screenshots/Video.gif" alt="">
</p>