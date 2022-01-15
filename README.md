# Игра "название придумаем"
***
# Зависимости
Надо будет установить GSON.  
Непосредственно ссылка на [Gson](https://github.com/google/gson).  
Тут можно смотреть на примеры написания, также это та версия которую будем использовать.
***
# Архитектура:

### abcpkg
В этом разделе у нас хранятся абстрактные классы, которые описывают тот или иной тип класса и его методы.

### data
Тут у нас находится папка под названием ***tools*** в которой у нас находятся классы для работы с JSON файлами.  
В самой папке ***data*** лежат файлы JSON, которые хранят в себе какие-либо данные, про это можно почитать в notion
или же в todo

### models
Тут у нас лежат модели, которые мы используем для того, чтобы можно было сохранять какие-либо данные 
или же выводить на экран, т.е. это уже те классы которые будут непосредственно у нас использоваться в приложении.

## Файлы Main & App
В классе App мы прописываем всю логику работы с нашим приложением, там же мы пропишем метод старт, 
который может запускать наше приложение на одно использование, этот метод будет, обернут в цикл уже в файле Main.
***
