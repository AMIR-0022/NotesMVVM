# Notes MVVM

<h3>MVVM with Room Database<h3>

<h4>Model:</h4>
Model is responsible for fetching the data either from the local SQLite database or from a web service. So it is further divided into various components.
<br>
  <b><u>Repository</u></b> — It is responsible for handling the data information that includes where to get the data from either a web service or the persisted data models.
<br>
  <b><u>Room DB</u></b> — It is an ORM provided by Google, which provides an abstraction layer between the SQLite database and our data in the form of objects. It gives us errors in compile-time, which is much better than run-time error which difficult to track and debug.
  
<br>

<h4>Views:</h4>
This part of our architecture help us build our user interface and the only part our users can interact directly. I consist of Fragment object defined in “src” and a layout resource. There is a two-way binding between them, which allows easy data sharing.

<br>

<h4>ViewModel:</h4>
ViewModel object acts as an intermediate between View and the Model, meaning it provides data for the UI components like fragments or activities. It also includes an observable data holder called LiveData that allows ViewModel to inform or update the View whenever the data get updated. It is very crucial, mainly to keep our app from reloading on orientation changes. Which ultimately provides a great user experience.

<br><br>

Author - Amir
