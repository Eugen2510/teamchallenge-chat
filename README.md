# Chat project
## For running:
- на комп'ютері має бути встановлено Docker
- запустити Docker
- при першому запуску зайти в корневу папку проєкту, з терміналу ввести команду: docker-compose build
- після цього з терміналу ввести команду docker-compose up
*Після цього додаток запуститься і буде слухати запити з localhost:8080*

## Робота локально для backend:
- додано файл application-dev.properties в якому прописані налаштування, за необхідності змінити під вашу бд та порти
- в файлі application.properties перший рядок - "spring.profiles.active=dev" дає команду брати налаштування з файлу application-dev.properties, весь код, записанний після ігнориться
- в application.properties прописані налаштування для запуску на Render.com, після злиття змін на гілку і для того, щоб зміни підхопив Render.com необхідно:
    - закоментувати рядок "spring.profiles.active=dev" в файлі application.properties
    - виконати команду .\gradlew clean з терміналу
    - виконати команду .\gradlew build з терміналу
    - запушити зміни на github
    - дані дії виконувати після тесту у себе локально, в тому випадку, якщо все працює

## Для QA та Frontend
- додаток розгорнуто за адресою https://teamchallenge-chat.onrender.com
- доступні ендпоїнти:
  - https://teamchallenge-chat.onrender.com/welcome-page/set-username - post, тіло запиту {"username" : "Alexandro"} встановлює ім'я юзера, додає в кукі id юзера, при повторній відправці імені від юзера з тим самим id, новий до бд не додається, оновлюється запис в бд
  - https://teamchallenge-chat.onrender.com/country/get-all - get повертає усі країни
  - https://teamchallenge-chat.onrender.com/country/get-id/{id} - get повертає країну за id
  - https://teamchallenge-chat.onrender.com/country/get-name/{country_name} - get повертає країну за іменем
  - https://teamchallenge-chat.onrender.com/region/get-All - get повертає усі доступні регіони
  - https://teamchallenge-chat.onrender.com/region/get-id/{id} - get повертає регіон за id
  - https://teamchallenge-chat.onrender.com/region/get-name/{name} - get повертає регіон за іменем регіону

