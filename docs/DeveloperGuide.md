---
layout: default.md
title: "Developer Guide"
pageNav: 3
---

# HomeBoss Developer Guide

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

_{ list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the
original source as well }_

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Design**

### Architecture

<puml src="diagrams/ArchitectureDiagram.puml" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** (consisting of
classes [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java)
and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java)) is
in charge of the app launch and shut down.

* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues
the command `delete 1`.

<puml src="diagrams/ArchitectureSequenceDiagram.puml" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding
  API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using
the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component
through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the
implementation of a component), as illustrated in the (partial) class diagram below.

<puml src="diagrams/ComponentManagers.puml" width="300" />

The sections below give more details of each component.

### UI component

The **API** of this component is specified
in [`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

<puml src="diagrams/UiClassDiagram.puml" alt="Structure of the UI Component"/>

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`
, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures
the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that
are in the `src/main/resources/view` folder. For example, the layout of
the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java)
is specified
in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` object residing in the `Model`.

### Logic component

**
API** : [`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<puml src="diagrams/LogicClassDiagram.puml" width="550"/>

The sequence diagram below illustrates the interactions within the `Logic` component, taking `execute("delete 1")` API
call as an example.

<puml src="diagrams/DeleteSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `delete 1` Command" />

<box type="info" seamless>

**Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of
PlantUML, the lifeline reaches the end of diagram.
</box>

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `AddressBookParser` object which in turn creates
   a parser that matches the command (e.g., `DeleteCommandParser`) and uses it to parse the command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeleteCommand`) which
   is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to delete a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<puml src="diagrams/ParserClasses.puml" width="600"/>

How the parsing works:

* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a
  placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse
  the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as
  a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser`
  interface so that they can be treated similarly where possible e.g, during testing.

### Model component

**
API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

<puml src="diagrams/ModelClassDiagram.puml" width="450" />


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which
  is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to
  this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as
  a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they
  should make sense on their own without depending on other components)

<box type="info" seamless>

**Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`,
which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique tag, instead of
each `Person` needing their own `Tag` objects.<br>

<puml src="diagrams/BetterModelClassDiagram.puml" width="450" />

</box>

### Storage component

**
API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

<puml src="diagrams/StorageClassDiagram.puml" width="550" />

The `Storage` component,

* can save both address book data and user preference data in JSON format, and read them back into corresponding
  objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only
  the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects
  that belong to the `Model`)

### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedAddressBook`. It extends `AddressBook` with an undo/redo
history, stored internally as an `addressBookStateList` and `currentStatePointer`. Additionally, it implements the
following operations:

* `VersionedAddressBook#commit()`— Saves the current address book state in its history.
* `VersionedAddressBook#undo()`— Restores the previous address book state from its history.
* `VersionedAddressBook#redo()`— Restores a previously undone address book state from its history.

These operations are exposed in the `Model` interface as `Model#commitAddressBook()`, `Model#undoAddressBook()`
and `Model#redoAddressBook()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedAddressBook` will be initialized with the
initial address book state, and the `currentStatePointer` pointing to that single address book state.

<puml src="diagrams/UndoRedoState0.puml" alt="UndoRedoState0" />

Step 2. The user executes `delete 5` command to delete the 5th person in the address book. The `delete` command
calls `Model#commitAddressBook()`, causing the modified state of the address book after the `delete 5` command executes
to be saved in the `addressBookStateList`, and the `currentStatePointer` is shifted to the newly inserted address book
state.

<puml src="diagrams/UndoRedoState1.puml" alt="UndoRedoState1" />

Step 3. The user executes `add n/David …​` to add a new person. The `add` command also calls `Model#commitAddressBook()`
, causing another modified address book state to be saved into the `addressBookStateList`.

<puml src="diagrams/UndoRedoState2.puml" alt="UndoRedoState2" />

<box type="info" seamless>

**Note:** If a command fails its execution, it will not call `Model#commitAddressBook()`, so the address book state will
not be saved into the `addressBookStateList`.

</box>

Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing
the `undo` command. The `undo` command will call `Model#undoAddressBook()`, which will shift the `currentStatePointer`
once to the left, pointing it to the previous address book state, and restores the address book to that state.

<puml src="diagrams/UndoRedoState3.puml" alt="UndoRedoState3" />


<box type="info" seamless>

**Note:** If the `currentStatePointer` is at index 0, pointing to the initial AddressBook state, then there are no
previous AddressBook states to restore. The `undo` command uses `Model#canUndoAddressBook()` to check if this is the
case. If so, it will return an error to the user rather
than attempting to perform the undo.

</box>

The following sequence diagram shows how the undo operation works:

<puml src="diagrams/UndoSequenceDiagram.puml" alt="UndoSequenceDiagram" />

<box type="info" seamless>

**Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the
lifeline reaches the end of diagram.

</box>

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once
to the right, pointing to the previously undone state, and restores the address book to that state.

<box type="info" seamless>

**Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address
book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()`
to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</box>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such
as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`.
Thus, the `addressBookStateList` remains unchanged.

<puml src="diagrams/UndoRedoState4.puml" alt="UndoRedoState4" />

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not
pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be
purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern
desktop applications follow.

<puml src="diagrams/UndoRedoState5.puml" alt="UndoRedoState5" />

The following activity diagram summarizes what happens when a user executes a new command:

<puml src="diagrams/CommitActivityDiagram.puml" width="250" />

#### Design considerations:

**Aspect: How undo & redo executes:**

* **Alternative 1 (current choice):** Saves the entire address book.
    * Pros: Easy to implement.
    * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
    * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
    * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_


--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**:

* has a home business
* want to oversee customers in an organised manner
* want to manage deliveries efficiently and effectively
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps

**Value proposition**: 
Home-based business owners can have a huge base of customers. 
HomeBoss streamlines and simplifies the management of customer contacts and deliveries,
thereby improving efficiency for business owners.

### User stories

Priorities: High (must have) - `***`, Medium (nice to have) - `**`, Low (unlikely to have) - `*`

| Priority | As a …​            | I want to …​           | So that I can…​                                                                                                                                                                         |
|-------|--------------------|------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `***` | an owner           | create a local account | I can personalise and secure my account.                                                                                                                                                |
| `***` | a registered owner | log in to my local account | I can access my data.                                                                                                                                                                   |
| `***` | a forgetful owner  | retrieve my account | I can still recover my data.                                                                                                                                                            |
| `***` | a logged-in owner  | log out of my account | I can keep my data secure.                                                                                                                                                              |
| `***` | a registered owner | update my password | I can constantly keep my data secure.                                                                                                                                                   |
| `***` | a registered owner | delete my account | I can have greater control over my data and account removal for privacy reasons.                                                                                                        |
| `***` | a registered owner | update my details | I can change my personalisation.                                                                                                                                                        |
| `***` | a registered owner | create a customer | I can tie deliveries to customers’ information.                                                                                                                                         |
| `***` | a registered owner | view a customer | I can see their detailed information.                                                                                                                                                   |
| `***` | a registered owner | update a customer | I can change details if keyed in wrongly.                                                                                                                                               |
| `***` | a registered owner | delete a customer | I can remove redundant or incorrect customer records, especially when unforeseen errors occur.                                                                                          |
| `***` | a registered owner | view a list of customers | I can have a comprehensive overview of my customer base.                                                                                                                                |
| `***` | a registered owner | see a list of deliveries sorted by status for the customer | I can easily see if products are delivered or not.                                                                                                                                      |
| `***` | a registered owner | quickly search for the details of a client | I can monitor the progress of an order efficiently and effectively.                                                                                                                     |
| `***` | a registered owner | create a delivery | I can efficiently organise and access delivery information.                                                                                                                             |
| `***` | a registered owner | create notes about deliveries | I can add additional information about deliveries.                                                                                                                                      |
| `***` | a registered owner | view a list of deliveries | I can plan the optimal route.                                                                                                                                                           |
| `***` | a registered owner | see the list of deliveries that would be delivered for the day | I can prioritise particular orders.                                                                                                                                                     |
| `***` | a registered owner | add a customer to a delivery | I know who the delivery is for.                                                                                                                                                         |
| `***` | a registered owner | remove a customer from a delivery | The delivery details are updated.                                                                                                                                                       |
| `***` | a registered owner | specify the method of delivery | I know how to send the orders over.                                                                                                                                                     |
| `***` | a registered owner | quickly search for the details of a delivery | I can monitor the progress of a                                                                 delivery.                                                                               |
| `***` | a registered owner | see a list of deliveries sorted by their delivery status and date of delivery | It is                                                                                                     more organised and easier for me to get and overview of all orders.           |
| `***` | a registered owner | see the location of the delivery | I know where to deliver the order to.                                                                                                                                                   |
| `***` | a registered owner | view the details of a delivery | I know what the order is and where to deliver it to.                                                                                                                                    |
| `***` | a registered owner | update the status of the delivery | I can keep track of the delivery progress and notify my client.                                                                                                                         |
| `***` | a registered owner | update delivery details | I can change any information if there was an error from                                                                                                                        user/me. |
| `***` | a registered owner | delete a delivery | I can get rid of deliveries that are redundant.                                                                                                                                         |
| `*`   | a registered owner | relate my inventory to my orders | I can keep track of my inventory.                                                                                                                                                       |
| `*`   | a registered owner | know the sum of all the materials required for a fixed delivery schedule | I can plan my                                                                                             inventory. |
| `*`   | a registered owner | have different user authorisation levels | I can control who has access to what.                                                                                                                                                   |

*{More to be added}*

### Use cases

(For all use cases below, the **System** is the `HomeBoss` and the **Actor** is the `user`, unless specified
otherwise)

#### Use Case: UC01 - Create Accoumt

**System:** User System (US)

**Actor:** Unregistered owner

**Preconditions:** User system has no account.

**Guarantees:**

* Account is created if the command is executed successfully.
* Unregistered owner is registered and logged in if the command is executed successfully.

**MSS:**

1. Unregistered owner opens HomeBoss application.
2. US asks unregistered owner to either login, forget password or register.
3. Unregistered owner enters register command with his username, password, confirm password, a forget password question
   and answer.
4. US creates an account and shows a welcome message with the newly created username.
   Use case ends.

**Extensions:**

* 3a. Unregistered owner does not enter one of the fields.

    * 3a1. US requests unregistered owner to fill up all the required fields.

      Use case ends.

* 3b. Unregistered owner types incorrect confirm password.

    * 3b1. US requests unregistered owner to retype their confirm password.

      Use case ends.

---

#### Use Case: UC02 - Login

**System:** User System (US)

**Actor:** Registered owner

**Preconditions:** Registered owner is logged out.

**Guarantees:**

* Registered owner is logged in.

**MSS:**

1. Registered owner opens the HomeBoss application.
2. US asks the registered owner to either login, forget password or register.
3. Registered owner enters the login command with his username, password.
4. US logs in and shows a welcome message.
   Use case ends.

**Extensions:**

* 3a. Registered owner does not enter one of the fields
    * 3a1. US requests registered owner to fill up all the required fields

      Use case ends.

* 3b. Registered owner types incorrect password or username
    * 3b1. US requests registered owner to retype their username or password

      Use case ends.

---

#### Use Case: UC03 - Forget Password

**System:** User System (US)

**Actor:** Registered owner

**Preconditions:** Registered owner is logged out.

**Guarantees:**

* Password would be changed.

**MSS:**

1. Registered owner opens the HomeBoss application.
2. US asks the registered owner to either login, forget password or register.
3. Registered owner enters the forgot password command with his username.
4. US asks the forget password question of the user.
5. Registered owner answers the question correctly.
6. US asks the registered owner to change password and confirm change password.
7. Registered owner types password and confirms password.
8. US logins and shows a success message.
   Use case ends.

**Extensions:**

* 3a. Registered owner does not enter the username field.
    * 3a1. US requests registered owner to fill up the username field.

      Use case ends.

* 3b. Registered owner types incorrect username
    * 3b1. US requests registered owner to retype their username

      Use case ends.

* 5a. Registered owner does not enter the answer field.
    * 5a1. US requests registered owner to fill up the answer field.

      Use case ends.

* 5b. Registered owner types incorrect answer
    * 5b1. US requests registered owner to retype their answer.

      Use case ends.

* 7a. Registered owner does not enter one of the password or confirm password fields.
    * 7a1. US requests registered owner to fill up all the required fields

      Use case ends.

* 7b. Registered owner types incorrect confirm password.
    * 7b1. US requests registered owner to retype their confirm password.

      Use case ends.


* *a. At any time, registered owner can choose to cancel the forget password.
    * *a1. Registered owner types cancel.
    * *a2. US asks the registered owner to either login, forget password or register.

      Use case ends.

---

#### Use Case: UC04 - Logout

**System:** User System (US)

**Actor:** Logged-In owner

**Preconditions:** Owner is logged in.

**Guarantees:**

* Logged-in owner would be logged out.

**MSS:**

1. Logged-In owner types logout
2. US logs owner out and shows success message.
   Use case ends.

---

#### Use Case: UC05 - Update Password

**System:** User System (US)

**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**

* Password of logged-in owner is updated.

**MSS:**

1. Logged-in owner types command to update password with password and confirm password.
2. User system shows a success message.
   Use case ends.

**Extensions:**

* 1a. Logged-in owner does not enter one of the fields
    * 1a1. US requests logged-in owner to fill up all the required fields

      Use case ends.

* 1b. Logged-in owner types incorrect confirm password
    * 1b1. US requests logged-in owner to retype their confirm password

      Use case ends.

---

#### Use Case: UC06 - Delete Account

**System:** User System (US)

**Actor:** Logged-in owner.

**Preconditions:** Owner is logged-in.

**Guarantees:**

* Logged-in owner’s account is deleted.

**MSS:**

1. Logged-in owner types command to delete his account.
2. User system shows a confirmation message.
3. Logged-in owner confirms.
4. User system shows a success message.
   
    Use case ends.

**Extensions**

* 3a. Logged-in owner cancels.
    * 3a1. Logged-in owner cancels.
    * 3a2. User system shows a cancellation message.

      Use case ends.

---

#### **Use case:** UC12 - Customer Detail Update

**System:** Customer Management System (CMS)

**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:** 
* Selected customer’s details are updated only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to update a customer’s details with at least one field specified.
2. CMS shows success message.

    Use Case Ends.

**Extensions:**
* 1a. Logged-in Owner does not specify at least one updated field(s).
  * 1a1. CMS displays an error to Logged-in Owner to specify at least one field to update.
    
    Use Case Ends.

* 1b. Logged-in Owner specifies invalid customer.
  * 1b1. CMS displays an error to Logged-in Owner that the specified customer does not exist.
  
    Use Case Ends.

* 1c. Logged-in Owner does not specify customer.
  * 1c1. CMS displays an error to Logged-in Owner to specify a customer to update.
    
    Use Case Ends.

---

#### **Use case:** UC13 - Customer Deletion

**System:** Customer Management System (CMS)

**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* Selected customer is deleted only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to delete a customer.
2. CMS shows success message.

    Use Case Ends.

**Extensions:**
* 1a. Logged-in Owner specifies invalid customer.
  * 1a1. CMS displays an error to Logged-in Owner that the specified customer does not exist.

    Use Case Ends.

* 1b. Logged-in Owner does not specify customer.
  * 1b1. CMS displays an error to Logged-in Owner to specify a customer to update.

    Use Case Ends.

---

#### **Use case:** UC14 - List Customers
**System:** Customer Management System (CMS)

**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* All Customers are listed only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to list all customers.
2. CMS shows list of all customers sorted by ascending alphanumeric order.

    Use Case Ends.

**Extensions:**
* 1a. Logged -in Owner specifies optional sort field.
    * 1a1. CMS shows list of all customers sorted by the specified sort order.

      Use Case Ends.

* 1b. Logged-in Owner specifies invalid sort field.
    * 1b1. CMS displays an error to Logged-in Owner to specify a valid sort option.

      Use Case Ends.

---

#### **Use case:** UC15 - Delivery Creation
**System:** Delivery Management System (DMS)

**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* A new delivery is created only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to create a delivery.
2. DMS shows success message.

    Use Case Ends.

**Extensions:**
* 1a. Command has missing fields.
  * 1a1. DMS displays an error to Logged-in Owner to specify all required fields.
  
    Use Case Ends.

* 1b. Command has invalid date.
  * 1b1. DMS displays an error to Logged-in Owner that an invalid date was given.
  
    Use Case Ends.

* 1c. Command has invalid date format.
  * 1c1. DMS displays an error to Logged-in Owner to specify the date in a valid format.
  
    Use Case Ends.

---

#### **Use case:** UC16 - Delivery Notes Creation

**System:** Delivery Management System (DMS)

**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* A new note is added to a delivery only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to create a note for a delivery.
2. DMS shows success message.

    Use Case Ends.

**Extensions:**
* 1a. Command has missing fields.
    * 1a1. DMS displays an error to Logged-in Owner to specify all required fields.

      Use Case Ends.

---

#### **Use case:** UC17 - Delivery List

**System:** Delivery Management System (DMS) 
**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* A list of deliveries is displayed only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to view a list of deliveries.
2. DMS displays a list of all deliveries sorted by delivery date.

    Use Case Ends.

**Extensions:**
* 1a. User specifies status field in command.
  * 1a1. DMS display a list of deliveries filtered by the specified status.
  
    Use Case Ends.

* 1b. User specifies sort field in command.
  * 1b1. DMS displays a list of all deliveries sorted by the specified sort order.
  
    Use Case Ends.

* 1c. User Specifies both status and sort fields.
  * 1c1. DMS displays a list of deliveries filtered by the specified status and sorted by the specified sort order.
    
    Use Case Ends.

---

#### **Use case:** UC18 - Delivery List for the Day

**System:** Delivery Management System (DMS) 
**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* A list of deliveries for the day is displayed only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to view a list of deliveries for the day.
2. DMS displays a list of deliveries for the day.

    Use Case Ends.

**Extensions:**
* 1a. Command has missing fields.
  * 1a1. DMS displays an error to Logged-in Owner.

    Use Case Ends.

---

#### **Use case:** UC19 - Add Customer to Delivery

**System:** Delivery Management System (DMS)
**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* A customer is added to a delivery only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to add a customer to a delivery.
2. DMS shows success message.

    Use Case Ends.

**Extensions:**
* 1a. Command has missing fields.
  * 1a1. DMS displays an error to Logged-in Owner to specify all required fields.

    Use Case Ends.

* 1b. Command has invalid customer details.
  * 1b1. DMS displays an error to Logged-in Owner that the specified customer details is invalid.

    Use Case Ends.

---

#### **Use case:** UC20 - Remove Customer from Delivery

**System:** Delivery Management System (DMS)
**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* A customer is removed from a delivery only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to remove a customer from a delivery.
2. DMS shows success message.

    Use Case Ends.

**Extensions:**
* 1a. Command has missing fields.
  * 1a1. DMS displays an error to Logged-in Owner to specify all required fields.

    Use Case Ends.

* 1b. Command has invalid customer details.
  * 1b1. DMS displays an error to Logged-in Owner that the specified customer cannot be found.
  
    Use Case Ends.

---

#### **Use case:** UC21 - Specify Delivery Method

**System:** Delivery Management System (DMS)
**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* A delivery method is specified only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command to specify a delivery method.
2. DMS shows success message.

    Use Case Ends.

**Extensions:**
* 1a. Command has missing fields.
  * 1a1. DMS displays an error to Logged-in Owner to specify all required fields.

    Use Case Ends.

* 1b. Command has invalid delivery options.
  * 1b1. DMS displays an error to Logged-in Owner that the specified delivery method is invalid.

    Use Case Ends.

---

#### **Use case:** UC22 - Search for Delivery

**System:** Delivery Management System (DMS)
**Actor:** Logged-in owner.

**Preconditions:** Owner is logged in.

**Guarantees:**
* A delivery is searched for only if the command is executed successfully.

**MSS:**
1. Logged-in Owner types command and keywords to search for a delivery.
2. DMS displays a list of deliveries that match the keywords in the search query.

    Use Case Ends.

**Extensions:**
* 1a. Command has missing fields.
  * 1a1. DMS displays an error to Logged-in Owner to specify all required fields.

    Use Case Ends.

---

### Non-Functional Requirements

1. Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2. Should be able to hold up to 
   1. 1000 customers without a noticeable sluggishness in performance for typical usage.
   2. 1000 deliveries without a noticeable sluggishness in performance for typical usage.
3. The system should be easily picked up by a novice with no experience with delivery management software.
4. A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be
   able to accomplish most of the tasks faster using commands than using the mouse.
5. Data stored should be persistent until removal by user, and Private Contact Details should be secure.
6. The project is expected to adhere to a schedule which delivers a feature set every milestone up to _V1.3_
7. The application is not expected to 
   1. Perform Inventory Management
   2. Perform Route Planning

*{More to be added}*

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Private Contact Detail**: A contact detail that is not meant to be shared with others
* **CLI**: Command Line Interface
* **Owner**: The person who owns the home-based business and who uses the app

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<box type="info" seamless>

**Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</box>

### Launch and shutdown

1. Initial launch

    1. Download the jar file and copy into an empty folder

    1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be
       optimum.

1. Saving window preferences

    1. Resize the window to an optimum size. Move the window to a different location. Close the window.

    1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Deleting a person

1. Deleting a person while all persons are being shown

    1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

    1. Test case: `delete 1`<br>
       Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message.
       Timestamp in the status bar is updated.

    1. Test case: `delete 0`<br>
       Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

    1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
       Expected: Similar to previous.

1. _{ more test cases …​ }_

### Saving data

1. Dealing with missing/corrupted data files

    1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_
