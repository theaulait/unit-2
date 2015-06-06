### Storing Files

#### Objective

Students will understand how to store data using shared preferences and internal and external storage.

#### Do Now (Morning)

> Create a `User` class. A User has a name and an age. Create a constructor and getters and setters for this object, and override toString so that it returns "$name, $age".

> Create an app with one main activity. The activity should include an EditText that takes in a user's name and
> a number representing the user's age, and a submission button.

> When a user hits the submit button, use the name and age fields to create a `User` object with that name and age. Store the `Users` in an array.

#### Lesson (Morning)

##### Shared Preferences

Shared Preferences are a way to store persistent key-value pairs. You can have multiple Shared Preferences files, or just one, and store and retrieve data with methods such as `putBoolean` and `getString`. Example code can be found [here](http://developer.android.com/guide/topics/data/data-storage.html#pref).

> Exercise

> Add a `total_users` counter to your app. Every time a user gets added, increment this value and toast how many users you've seen. Store/retrieve `total_users` in shared preferences so that this number always increases across uses.

##### File Object

[File](http://developer.android.com/reference/java/io/File.html) - The File object represents a File and can be used to create, delete, read from, and write to a File. You can also use this object to manage File permissions and metadata.

##### Serializing Data

An Object is serialized when it is turned into a stream of bytes so it can be written to a file, and deserialized when it is turned back into an Object using the stream of bytes. An Object that does these can implement the [Serializable](http://developer.android.com/reference/java/io/Serializable.html) interface. In order to be serializable and deserializable, you can create/use [ObjectOutputStream](http://developer.android.com/reference/java/io/ObjectOutputStream.html) and [ObjectInputStream](http://developer.android.com/reference/java/io/ObjectInputStream.html).

> Exercise

> Make the `User` object `Serializable`.

#### Do Now (Afternoon)

> Add a spinner (dropdown), and populate the spinner with your `Users` array.

#### Lesson (Afternoon)

##### Querying Free Space

One of the tricky things about writing code for mobile devices is the limited amount of free space (and resources in general, including local resources all well as non-gaurantees of internet connectivity and bandwidth). When you run out of space, you will get an IOException. If you know (or can ballpark) the amount of space you'll need beforehand, you can use [`getFreeSpace()`](http://developer.android.com/reference/java/io/File.html#getFreeSpace()) and [`getTotalSpace()`](http://developer.android.com/reference/java/io/File.html#getTotalSpace()) on the `File` object to know if you'll have enough space.

##### [Internal vs External Storage](http://developer.android.com/training/basics/data-storage/files.html#InternalVsExternalStorage)

All devices have internal storage (built-in storage). External storage is typically a device such as an SD card, although sometimes the external storage is nonremovable. Internal storage is always available (unlike external storage). When a user deletes your app, the associated internal storage is deleted by default, but the associated external storage is not deleted by default. Interal storage is typically only meant to be read by the app, wheras external storage is world-readable. Internal storage is more suited to something like a database; external storage might be for memes that a user has created.

##### Saving a file to internal storage

To get the files directory, use [`getFilesDir()`](http://developer.android.com/reference/android/content/Context.html#getFilesDir()) which will tell you the path of where the files are stored.

Create a `FileOutputStream` object, write to the stream, and then close it:

```
String FILENAME = "hello_file";
String string = "hello world!";

FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
fos.write(string.getBytes());
fos.close();
```

See also [Using Internal Storage](http://developer.android.com/guide/topics/data/data-storage.html#filesInternal) and [Save a File on Internal Storage](http://developer.android.com/training/basics/data-storage/files.html#WriteInternalStorage).

> Exercise

> Using the serialized `User` object, whenever a new `User` is added, add it as a line in the file. Use this file
to populate the spinner.

##### Saving a file to external storage

###### Permissions

In the Manifest file, you must add permissions to access external storage. In order to read from external storage, include the line:

```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```

In order to write to external storage, include the line:

```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

Note that, as with the File object, read permissions and write permissions are separate (as are execution permissions). This division of permissions is typical.

###### Reading and Writing

Check [`Environment.getExternalStorageState()`](http://developer.android.com/reference/android/os/Environment.html#getExternalStorageState()). The state may read and write, read only, or not avaialble.

Get the public files directory using [`getExternalStoragePublicDirectory()`](http://developer.android.com/reference/android/os/Environment.html#getExternalStoragePublicDirectory(java.lang.String)) or [`getExternalFilesDir()`](http://developer.android.com/reference/android/content/Context.html#getExternalFilesDir(java.lang.String)) for private files.

Write to the file stream and close.

See also [Using External Storage](http://developer.android.com/guide/topics/data/data-storage.html#filesExternal) and [Save a File on External Storage](http://developer.android.com/training/basics/data-storage/files.html#WriteExternalStorage).

> Exercise

> Do the same thing, saving the serialized `User` object and populating the spinner, but instead saving to and reading from external storage.

##### Deleting a File

Delete a `File` with the [`delete()`](http://developer.android.com/reference/java/io/File.html#delete()) method, or by calling [`deleteFile()`](http://developer.android.com/reference/android/content/Context.html#deleteFile(java.lang.String)) on the `Context`.

> Exercise

> Add a "clear all" button to the main activity. When this button gets pressed, delete the file.

##### Tools

(Accessing a file with ADB etc.)

#### Assessment

[Exit Ticket](https://docs.google.com/forms/d/1a-gfjjsn35N-C6wrQU9y02vHoYLFaEfjUgD7J91n3rM/viewform?usp=send_form)
