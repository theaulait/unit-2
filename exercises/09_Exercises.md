### Exercises

#### Instructions

Pair program for this activity. This is not an individual activity.
Whomever has less mastery of the material should drive.

#### Requirements

Create a new Android Project.

A superperson has three fields: a superperson name, a secret identity (also a name), and list of powers. 

Create an abstract `Superperson` class. Choose how you want to represent each of the fields.
Create the appropriate getters and setters, and constructor(s).

Use an adapter to create a ListView that displays a list of `Superperson`s and their traits.

Create a `Superhero` class and a `Supervillian` class, both inheriting from `Superperson`. Add any differentiating
traits you might want each to have.

In your `onCreate` method, create a bunch of `Superhero`s and `Supervillian`s - feed these objects to the adapter
to populate the `ListView`.

#### Bonus

Include a feature such that when you click a `Superperson` in the `ListView`, you see more detailed information about
the `Superperson`.
