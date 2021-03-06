# Storage-Control
Storage Control Web App (Groovy/Grails, GSP, HTML/CSS)

Веб-приложение системы управления складом.
Имеет следующие функции:
- Можно внести информацию об одном товаре.
- Можно загрузить .xls/.xlsx/.csv во время приемки товаров (колонки - внешний id, название, количество - это минимальные
  данные при импорте данных, если не будет одной из них, то система не импортирует информацию о товаре.
  Так же внешний id предписан быть уникальным, т.е. система не импортирует информацию о товаре, если продукт с 
  таким id уже существует в базе данных)
- Можно просмотреть что есть на складе + есть поиск по названию / бренду.
- Можно сделать выгрузку результатов поиска в .xlsx. А так же выгрузить весь список товаров из базы данных.
- Отдельная страница - товары которые подходят к концу, осталось меньше 5 штук.

В системе предустановлены два пользователя: admin(password:admin) и user(password:user), которые создаются при первом запуске
приложения. Пользователь user может просматривать товары в базе, пользоваться поиском и делать выгрузку данных в .xlsx.
Дополнительно к возможностям пользователя user, пользователь admin может вносить информацию о новых товарах, просматривать, 
редактировать и удалять из базы уже существующие товары. Так же пользователю admin доступен импорт данных о вновь вносимых товарах из .xls/.xlsx/.csv файлов.

Для запуска приложения требуется MySQL база данных с названием 'storage' доступная по адресу localhost:3306/storage.
Так же требуется созданный пользователь для доступа к базе данных с именем : 'storagemanager' и паролем: '123456'.
Не забудьте включить службу MySQL56 перед запуском приложения.

Используемые библиотеки и плагины при написании приложения:
- Grails 2.4.4
- Hibernate 3.6.10.18
- Spring security core 2.0-RC3
- Excel export 0.2.1
- Excel import 1.0.0
- Csv 0.3.1
- Searchable 0.6.9
- Для связи приложения с базой данных используется драйвер mysql-connector-java 5.1.29.

Приложение написано без использования какой-либо IDE.
