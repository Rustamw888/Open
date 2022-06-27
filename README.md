# Проект по автоматизации тестирования для банка Открытие
## <a target="_blank" href="https://www.open.ru/">Веб сайт Открытие</a>

![This is an image](https://i.imgur.com/6XuTbtM.png)

## :rocket: Содержание:

- [x] <a href="#rocket-технологии-и-инструменты">Технологии и инструменты</a>
- [x] <a href="#rocket-реализованные-проверки">Реализованные проверки</a>
- [x] <a href="#rocket-сборка-в-Jenkins">Сборка в Jenkins</a>
- [x] <a href="#rocket-запуск-из-терминала">Запуск из терминала</a>
- [x] <a href="#rocket-allure-отчет">Allure отчет</a>
- [x] <a href="#rocket-интеграция-с-allure-testops">Интеграция с Allure TestOps</a>
- [x] <a href="#rocket-интеграция-с-jira">Интеграция с Jira</a>
- [x] <a href="#rocket-отчет-в-telegram">Отчет в Telegram</a>
- [x] <a href="#rocket-видео-примеры-прохождения-тестов">Видео примеры прохождения тестов</a>

## :rocket: Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

## :rocket: Реализованные проверки это смоук тесты
![This is an image](https://i.imgur.com/Dd62Cq5.png)
- Проверка вкладки 'Private Banking'
- Проверка вкладки 'Финансовым институтам'
- Проверка вкладки 'Малому и среднему бизнесу'
- Проверка заголовков главной страницы
- Отсутствие ошибок в консоли

## :rocket: Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/AUTO-Rustam_open/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/screenshots/jenkins_dashboard.png">
</p>

### Параметры сборки в Jenkins:
Сборка в Jenkins

- browser (браузер, по умолчанию chrome)
- version (версия браузера, по умолчанию 100.0)
- size (размер окна браузера, по умолчанию 1920x1080)
- threads (количество потоков)

## :rocket: Запуск из терминала
Локальный запуск:
```
gradle clean openTest
```

Удаленный запуск:
```
clean
openTest
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://${REMOTE_LOGIN}:${REMOTE_PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

## :rocket: Allure отчет
- ### Главный экран отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/report_main_page.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/screenshots/report_tests_page.png">
</p>

## :rocket: Интеграция с Allure TestOps
- ### Экран с результатами запуска тестов
<p align="center">
<img title="TestOps Launch Page" src="images/screenshots/test_ops_launch_page.png">
</p>

- ### Страница с тестами в TestOps
<p align="center">
<img title="TestOps tests page" src="images/screenshots/test_ops_tests_page.png">
</p>

- ### Страница с тестами в TestOps auto + manual
<p align="center">
<img title="TestOps tests page" src="images/screenshots/test_ops_manual.png">
</p>

- ### Экран с результатами запуска тестов auto + manual
<p align="center">
<img title="TestOps Launch Page" src="images/screenshots/allure_manual_results.png">
</p>

## :rocket: Интеграция с Jira
- ### Страница с задачей в Jira
<p align="center">
<img title="Jira issue" src="images/screenshots/jira_issue.png">
</p>

## :rocket: Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/screenshots/telegram_report.png">
</p>

## :rocket: Видео примеры прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
> И оно могло бы быть примерно таким, если бы альфа банк меня не заблочил)))
<p align="center">
  <img title="Selenoid Video" src="images/gif/test_result.gif">
</p>



