# User Guide

# About HomeBoss

HomeBoss is a desktop application for **home-based business owners** to **manage their Customers and Deliveries**.
HomeBoss streamlines the process of your operations, optimises your resources, and enhances your overall business
experience.

With our application, you will be able to:

* Keep track of the details of your Customers and Deliveries
* Search for a particular Customer/Delivery easily
* Organise your data in a neat and tidy manner by filtering and sorting to your needs </br>
and much more!

All these are done to improve your efficiency and productivity all while being incredibly simple to use.
HomeBoss is also **optimised for fast typist with the use of a Command Line Interface (CLI)**, allowing you to
execute commands quickly. On top of that, we utilise a *Graphical User Interface (GUI)* to let you view your
data in a neater and more organised manner.

Essentially, with HomeBoss, you can **focus on what matters most: running your business**.

---

# Table of Contents

&nbsp;&nbsp;1\. [About HomeBoss](#about-homeboss)</br>
&nbsp;&nbsp;2\. [Table of Contents](#table-of-contents)</br>
&nbsp;&nbsp;3\. [About this User Guide](#about-this-user-guide)</br>
&nbsp;&nbsp;4\. [Navigating the User Guide](#navigating-the-user-guide)</br>
&nbsp;&nbsp;5\. [Getting Started](#getting-started)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.1 [Prerequisites](#prerequisites)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.2 [Installing HomeBoss](#installing-homeboss)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.3 [Understanding our layout](#understanding-our-layout)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.4 [HomeBoss's Command Format](#homeboss-s-command-format)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.5 [Registering and creating your first Delivery](#registering-and-creating-your-first-delivery)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.6 [Editing the data file](#editing-the-data-file) </br>
&nbsp;&nbsp;6\. [Feature Summary](#feature-summary)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.1 [User features summary](#user-features-summary)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.2 [Customer features summary](#customer-features-summary)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.3 [Delivery features summary](#delivery-features-summary)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.4 [Miscellaneous features summary](#miscellaneous-features-summary)</br>
&nbsp;&nbsp;7\. [Features](#features)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.1 [User](#user)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.1.1 [Register](#register)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.1.2 [Login](#login)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.1.3 [Update Account details](#update-account-details)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.1.4 [Logout](#logout)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.1.5 [Recover Account](#recover-account)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.1.6 [Delete Account](#delete-account)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.2 [Customer](#customer)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.2.1 [Add a Customer](#add-a-customer)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.2.2 [View details of a Customer](#view-details-of-a-customer)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.2.3 [View a list of Customers](#view-a-list-of-customers)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.2.4 [Find Customers](#find-customers)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.2.5 [Update details of a Customer](#update-details-of-a-customer)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.2.6 [Delete a Customer](#delete-a-customer)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3 [Delivery](#delivery)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3.1 [Add a Delivery](#add-a-delivery)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3.2 [View details of a Delivery](#view-details-of-a-delivery)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3.3 [View a list of Deliveries](#view-a-list-of-deliveries)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3.4 [Find Deliveries](#find-deliveries)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3.5 [Update details of a Delivery](#update-details-of-a-delivery)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3.6 [Update status of a Delivery](#update-status-of-a-delivery)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3.7 [Create a note for a Delivery](#create-a-note-for-a-delivery)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.3.8 [Delete a Delivery](#delete-a-delivery)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.4 [Miscellaneous](#miscellaneous)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.4.1 [Help](#help)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.4.2 [Exit](#exit)</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.4.3 [Clear](#clear)</br>
&nbsp;&nbsp;8\. [FAQ](#faq)</br>
&nbsp;&nbsp;9\. [Command Summary](#command-summary)</br>

---

# About this User Guide

This user guide provides you with everything that you need to know when using HomeBoss.

If you are new to HomeBoss, head over to the [Getting Started](#getting-started) section for a quick overview
on how to get started.

Additionally, this user guide provides you with detailed explanations of all the features available
in the [Features](#features) section.

For experienced users, you may refer to the [Command Summary](#command-summary) section for a quick summary of all the
commands available in HomeBoss.

If you would like to learn about the technical aspects of HomeBoss,
you may refer to the [Developer Guide](./DeveloperGuide.md).

# Navigating the User Guide

**Warning Box**

<box type="warning" background-color="#f2dede" border-color="#ebccd1" icon=":exclamation:">

**Warning:** Provides you with important information to take note of to avoid any unintended effects!

</box>

**Note Box**

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:** Provides you with information that is useful to know.

</box>

**Tip Box**

<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip:** Provides you with information that can help enhance your user experience but is not necessary to know.

</box>

**Parameter Box**

<box type="info" background-color="#fcf8e3" border-color="#fcf8ff" icon=":gear:">

**Parameters:** Parameters are inputs that you can customise to your needs. They are typically preceded by a prefix. If you're unsure what a prefix is, you can refer to the [Command Format](#homeboss-s-command-format) section.

</box>

**Links**

* Words in blue are [links](#navigating-the-user-guide) that you can click on to navigate to the relevant section.

* A [&uarr; Back to Table of Contents](#table-of-contents) link is available at the end of every section
  for you to return to the Table of Contents, so that you can access another section from there easily.

---

# Getting Started

## Prerequisites

Ensure that you have `Java 11`{.swift} or above installed on your computer. If you are unsure how to do so you may view
this
helpful [guide](https://www.java.com/en/download/help/version_manual.html).

<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip**: You may find the following links helpful should you need to install `Java 11`{.swift}

1. [Java 11 Release](https://www.oracle.com/java/technologies/downloads/#java11).
2. [Java 11 Installation Guide](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
   .

</box>

## </br>Installing HomeBoss

1. You may download the latest release of **HomeBoss**
   from [here](https://github.com/AY2324S1-CS2103T-T13-3/tp/releases/latest).
   (Please download the file named `HomeBoss.jar`{.swift})
2. Move the downloaded file `HomeBoss.jar`{.swift} into the folder that you want to use as the home folder for your
   application.

<box type="warning" background-color="#f2dede" border-color="#ebccd1" icon=":exclamation:">

**Warning**: The folder that you would like to use as the home folder must be empty and should not contain any other
files/folder before the application is launched for the first time.

</box>

3. Run `HomeBoss.jar`{.swift}. If you are unsure how to run a `.jar` file, you may refer to this helpful
   [guide](https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Run-JAR-file-example-windows-linux-ubuntu)
   .
4. If everything went well, you should be greeted by a window similar to the one below.
5. We recommend reading how to [understand the layout](#understanding-the-layout)
   and familiarizing yourself with [HomeBoss's command format](#homebosss-command-format)
   before learning how to [add your first delivery](#adding-your-first-delivery).

![HomeBoss Start Page](images/getting-started/register.png)

## Understanding our layout

Don't worry if you don't understand what you're looking at. Let's go through a quick run down of HomeBoss's layout
so that you can familiarise yourself with our various components.

![HomeBoss Home Page](images/getting-started/homepage_annotated.png)

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note**: The above image is an example with sample data and may not be what you see when you launch
the application for the first time.

</box>

### Command Box

![HomeBoss Command Box](images/getting-started/command_box.png){style="display: block; margin: 0 auto;"}

The Command Box is where you will be interacting with HomeBoss, it is the place where all commands
will be entered. Try typing the `help`{.swift} command and hitting enter!

### Command Result/FeedBack

![Command Result FeedBack](images/getting-started/help_feedback.png){style="display: block; margin: 0 auto;"}

The Command Result/Feedback Box is where HomeBoss will provide you the results or feedback about
the commands you entered. For example, if you tried typing the `help`{.swift} command earlier, you should see
the above feedback in your application window, together with a Help window popup.
You can use the scroll bar on the right to scroll through a long result or feedback!

### Customer/Delivery List

<table class="images" style="border:0px solid white; width:100%; text-align: center">
    <tr style="width:100%;border: 0;">
        <td>
            <img src="images/getting-started/customer_list_cropped.png" style="width: 80%;display: block; margin: 0 auto;">
        </td>
        <td>
            <img src="images/getting-started/delivery_list_cropped.png" style="width: 80%;display: block; margin: 0 auto;">
        </td>
    </tr>
    <tr >
        <td style="padding-top: 10px; padding-bottom: 20px">List of Customers</td>
        <td style="padding-top: 10px; padding-bottom: 20px">List of Deliveries</td>
    </tr>
</table>

The Customer/Delivery List Panel is where you will be able to find the Customers and Deliveries that you have added to
HomeBoss. You can use the scroll bar on the right to scroll through your Customers or Deliveries.

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note**: 

* The `ID`{.swift} that appears next to each name is a unique identifier given to all added Customers and
  Deliveries separately, and is required to perform many of HomeBoss's commands.
  More details of these commands can be found in [Features](#features).
* The `ID`{.swift} generated are guaranteed to be unique but may not be consecutive and may not start from 1.
  
![Command Result FeedBack](images/getting-started/delivery_card.png){style="display: block; margin: 0 auto;"}

</box>

## </br>HomeBoss's Command Format

Commands are your main form of interaction with HomeBoss, and is the way to carry out various operations in HomeBoss.
Don't worry if the commands seem daunting, the HomeBoss team has carefully crafted the commands to be as intuitive
and simple as possible. After learning the commands, you'll be faster than ever!

Every command has a **Command Phrase** and possibly one or more **Parameters**
(inputs to customise the command to your needs) which is typically preceded by a **Prefix**
(special markers for HomeBoss to understand your inputs)

Take the [Add Delivery Command](#add-delivery) for example:

```swift
delivery add DELIVERY_NAME --customer CUSTOMER_ID --date DELIVERY_DATE
```

* The **Command Phrase** is `delivery add`{.swift}
* The **Parameters** are the words in `UPPER_CASE`{.swift}, for example `DELIVERY_NAME`{.swift} or `CUSTOMER_ID`{.swift}
* The **Prefixes** are special keywords that are preceded by `--`{.SWIFT}, such as `--customer`{.swift} and
  `--date`{.swift}

<br />

However, not all commands have **Prefixes**, take the
[Update Delivery Status Command](#update-delivery-status) for example:

```swift
delivery status STATUS CUSTOMER_ID
```

* The **Command Phrase** is `delivery status`{.swift}
* The **Parameters** are `STATUS`{.swift} and `CUSTOMER_ID`{.swift}
* It has no **Prefixes**

<br />

Not all commands have **Parameters** as well, take the
[Logout Command](#logout) for example:

```swift
logout
```

* The **Command Phrase** is `logout`{.swift}
* It has no **Parameters**

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note**:

* Command Phrase are keywords or short phrases that are unique to each Command.
* Words that are in `UPPER_CASE`{.swift} are parameters that are to be supplied by you.
* Parameters that are preceded by a prefix must be supplied after that prefix, e.g. `--name DELIVERY_NAME`{.swift}
  must be given as, for example, `--name furniture`{.swift} and not `furniture`{.swift} or `--name`{.swift}
* Items that are placed in square brackets (`[]`{.swift}) are optional, e.g. `DELIVERY_ID [--name DELIVERY_NAME]`
  {.swift} can either be
  `1`{.swift} or `1 --name furniture`{.swift}.
* However, items that are grouped together in square brackets (`[]`{.swift}) must all be provided together,
  e.g. for `[--password PASSWORD --confirmPass CONFIRM_PASSWORD]`{.swift} both `PASSWORD`{.swift} and
  `CONFIRM_PASSWORD`{.swift} must be provided.
* Extraneous parameters for commands that do not have parameters (e.g. `customer list`{.swift} or `clear`{.swift}) will
  be ignored, e.g. `customer list 123`{.swift}.
* Parameters that have `...`{.swift} as a postfix can be given one or more times, e.g. `KEYWORDS...`{.swift} can be
  given as `Query`{.swift} or `Query AnotherQuery`{.swift}.
* **Command Phrase** and **Prefixes** are **case-sensitive**! e.g. `clear`{.swift} is a valid command word but
  `customer LIST`{.swift} is not a valid command word.
* Leading and trailing whitespaces of parameters will be trimmed, i.e., spaces added between `--password`{.swift}  and `PASSWORD`{.swift}  in `--password PASSWORD`{.swift} will be removed.

  </box>

## </br>Registering and creating your first Delivery

Hopefully at this point, you have a good understanding of the basics of HomeBoss. Let's get you started on HomeBoss
by creating your first Delivery

1. First register for HomeBoss using the `register`{.swift} command. So, for example, if you want to register an account
   with the following details:

* `USERNAME`{.swift}: Alex123
* `PASSWORD`{.swift}: AlexIsGreat
* `CONFIRM_PASSWORD`{.swift}: AlexIsGreat
* `SECRET_QUESTION`{.swift}: First Pet Name? 
* `ANSWER`{.swift}: KoKo 

Type `register --user Alex123 --password AlexIsGreat --confirmPass AlexIsGreat --secretQn First Pet Name? 
--answer Koko`{.swift} into the Command Box and hit enter. More details on the command can be found [here](#register).

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note**: Only 1 account can be registered to HomeBoss at any one time.

</box>

2. After registering for an account, you will be greeted by HomeBoss's home page. It's empty at the moment, so let's populate it with some data.

3. Let's assume that a new Customer, Gabriel, is to be added, using the `customer add`{.swift} command.

* `NAME`{.swift}: Gabriel
* `PHONE`{.swift}: 87654321
* `EMAIL`{.swift}: gabrielrocks@gmail.com
* `ADDRESS`{.swift}: RVRC Block B

4. Type `customer add --name Gabriel --phone 87654321 --email gabrielrocks@gmail.com --address RVRC Block B`{.swift}
   into the Command Box and hit enter.

5. A new Customer called Gabriel should be added, you should see a new Customer similar to the image below.

![CustomerAdded](images/getting-started/customer_add.png){style="display: block; margin: 0 auto;"}

6. Now, let's add a new Delivery for Gabriel into HomeBoss, suppose Gabriel ordered a MacBook Pro.

* `DELIVERY_NAME`{.swift}: MacBook Pro
* `DELIVERY_DATE`{.swift}: 2023-12-03

7. Type `delivery add MacBook Pro --customer CUSTOMER_ID --date 2023-12-03`{.swift}, replacing `CUSTOMER_ID`{.swift} 
   with Gabriel's ID, and hit enter.

8. A new Delivery should have been added for Gabriel, you should see a new Delivery similar to the image below.

![DeliveryAdded](images/getting-started/delivery_add.png){style="display: block; margin: 0 auto;"}

Congratulations! You have just successfully added your first Customer and Delivery!

HomeBoss has many other features for you to try to streamline your Delivery workflow. Take a look at our
[Features](#features) below for even more commands and their details!

---

## </br>Editing the data file

HomeBoss stores your data in a JSON file automatically `[JAR file location]/data/addressbook.json`{.swift}. Advanced 
users are welcome to update data directly by editing the data file. 

<box type="warning" background-color="#f2dede" border-color="#ebccd1" icon=":exclamation:">

**Warning:** If the files are edited and contain invalid data, HomeBoss will discard the entire data file and start with an empty data file during the next run. (If the Customer data file contains invalid data, the entire Delivery data file will also be deleted. However, if the Delivery data file contains invalid data, the Customer data file will remain unaffected.)

</box>

---

# Feature Summary

Here is a brief introduction to all the features in HomeBoss. For more detailed information, please
refer to the [Features](#features) section.

## User features summary

_These are features for managing your user account in HomeBoss._

- `register` - Registers a new user account to use HomeBoss.
- `login` - Logs in to your user account.
- `update` - Updates your user account details.
- `recover account` - Recovers your user account.
- `logout` - Logs out of your user account.
- `delete account` - Deletes your user account.

## Customer features summary

_These are features for managing your Customers in HomeBoss._

- `customer add` - Adds a Customer to the address book.
- `customer view` - Shows the details of the specified Customer.
- `customer list` - Lists all Customers in the address book.
- `customer find` - Finds Customers whose names contain any of the given keywords.
- `customer edit` - Updates the details of an existing Customer in the address book.
- `customer delete` - Deletes the specified Customer from the address book.

## Delivery features summary

_These are features for managing your Deliveries in HomeBoss._

- `delivery add` - Adds a Delivery to the delivery book.
- `delivery view` - Shows the details of the specified Delivery.
- `delivery list` - Lists all Deliveries in the delivery book.
- `delivery find` - Finds Deliveries whose names contain any of the given keywords.
- `delivery edit` - Updates the details of an existing Delivery in the delivery book.
- `delivery status` - Changes the status of a specified Delivery.
- `delivery note` - Creates a note for a specified Delivery.
- `delivery delete` - Deletes the specified Delivery from the delivery book.

## Miscellaneous features summary

_These are general features in HomeBoss._

- `exit` - Exits the program.
- `help` - Shows a list of commands and their usage.
- `clear` - Clears both Customer and Delivery database. **Warning:** This action is irreversible.


<br/>

[&uarr; Back to Table of Contents](#table-of-contents)

---

# Features

## <span style="text-decoration:underline;"><strong>User</strong></span>

### Register

You can register for a new user account with HomeBoss by calling this command.

</br>**Format:**

`register --user USERNAME --password PASSWORD --confirmPass CONFIRM_PASSWORD --secretQn SECRET_QUESTION --answer ANSWER`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* `USERNAME`{.swift} must be alphanumeric.
* `PASSWORD`{.swift} must be at least 8 alphanumeric characters long.
* `CONFIRM_PASSWORD`{.swift} must be the same as `PASSWORD`{.swift}.
* `SECRET_QUESTION`{.swift} can include any characters but must not be empty.
* `ANSWER`{.swift} can include any characters but must not be empty.
* `SECRET_QUESTION`{.swift} and `ANSWER`{.swift} will be used for account recovery.
* Only one account can be registered at any one time.

  </box>

</br>**Example:**

* `register --user Gabriel --password GabrielIsGreat --confirmPass GabrielIsGreat --secretQn First Pet Name? --answer Koko`{.swift}</br>

  Registers a new user account with the username `Gabriel`{.swift}, password `GabrielIsGreat`{.swift}, secret
  question `First Pet Name?`{.swift} and answer `Koko`{.swift}.

<br />

<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip:** Since only one account can be registered at any one time, if you have already registered an account, you will not be able to register another account. If you must, you can delete your current account by using the `delete account`{.swift} command [here](#delete-account) before registering a new account.
</box>

<br/>

[&uarr; Back to Table of Contents](#table-of-contents)
</br>

### </br></br>Login

You can log in to your account to access your Customer and Delivery data by calling this command.

</br>**Format:** 

`login --user USERNAME --password PASSWORD`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* `USERNAME`{.swift} must be alphanumeric.
* `PASSWORD`{.swift} must be at least 8 alphanumeric characters long.
* You need to already have an account registered with HomeBoss.

  </box>

</br>**Example:**

* `login --user Gabriel --password GabrielIsGreat`{.swift} </br>
  Logs in to the user account with the username `Gabriel`{.swift} and password `GabrielIsGreat`{.swift}.

![](images/ug/login.png)
</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Update Account details

This command allows you to update your account details, thus enabling greater security and personalisation.

</br>**Format:** 

`update [--user USERNAME] [--password PASSWORD --confirmPass CONFIRM_PASSWORD]
[--secretQn SECRET_QUESTION --answer ANSWER]`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* At least one of the optional fields must be provided.
* The details will be updated without checking against the current details.
* `USERNAME`{.swift} must be alphanumeric.
* `PASSWORD`{.swift} must be at least 8 alphanumeric characters long.
* `CONFIRM_PASSWORD`{.swift} must be the same as `PASSWORD`{.swift}.
* `SECRET_QUESTION`{.swift} can take any characters.
* `ANSWER`{.swift} can take any characters.

  </box>

</br>**Example:**

* `update --user GabrielV2 --password GabrielIsBest --confirmPass GabrielIsBest
  --secretQn Favourite Pet --answer BoBo`{.swift} </br>
  Updates the username to `GabrielV2`{.swift}, password to `GabrielIsBest`{.swift},
  secret question to `Favourite Pet`{.swift} and answer to `BoBo`{.swift}.

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Logout

You can log out of your account to keep your data secure at the end of the day by calling this command.

<br/>

**Format:** `logout`{.swift}

</br>

[&uarr; Back to Table of Contents](#table-of-contents)
</br>

### </br></br>Recover Account

HomeBoss makes it easy for you to recover your account if you forget your password. You only need the answer to the
secret question (set during account registration) to reset your password and thus regain access to your account.

</br>**Format:** 

`recover account [--answer ANSWER --password NEW_PASSWORD --confirmPass CONFIRM_PASSWORD]`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* If `ANSWER`{.swift} is provided, `NEW_PASSWORD`{.swift} and `CONFIRM_PASSWORD`{.swift} must also be provided and vice
  versa.
* `ANSWER`{.swift} can take any characters.
* `NEW_PASSWORD`{.swift} must be at least 8 alphanumeric characters long.
* `CONFIRM_PASSWORD`{.swift} must be the same as `NEW_PASSWORD`{.swift}.

  </box>

</br>**Examples:**

* `recover account`{.swift} </br>
  Displays your account's secret question for account recovery.

* `recover account --answer Koko --password NewPassword123 --confirmPass NewPassword123`{.swift} </br>
  Recovers the account with the answer `Koko`{.swift} and sets the new password to `NewPassword123`{.swift}.

</br>**Without optional fields (i.e., `recover account`{.swift} ):**
![](images/user/userRecoverAccount_after_secretQn.png)

</br>**With optional fields (i.e.,
`recover account --answer Koko --password NewPassword123 --confirmPass NewPassword123`{.swift}):**
![](images/user/userRecoverAccount_after_answer.png)

</br>

[&uarr; Back to Table of Contents](#table-of-contents)
</br>

### </br></br>Delete Account

If you simply want to erase all your data from HomeBoss, you can delete your account by calling this command.

</br>**Format:** `delete account`{.swift}

<br />

<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip:** This command should be considered as a last resort, to be used if you forget both your password and your secret answer.
However, if you've forgotten your password but recall the answer to your secret question, you can initiate the account
recovery process by using the `recover account`{.swift} command [here](#recover-account).

</box>

</br>

[&uarr; Back to Table of Contents](#table-of-contents)
</br>

## </br><span style="text-decoration:underline;"><strong>Customer</strong></span>

### Add a Customer

You can add a new Customer's details into HomeBoss with this command.

<br />
<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:** Customers consist of a name, a phone number, an email, and an address.</br> </br>

</box>

</br>**Format:** 

`customer add --name NAME --phone PHONE_NUMBER --email EMAIL --address ADDRESS`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* HomeBoss does not allow you to add Customers with the same phone number.
* A unique customer ID (may not be consecutive) will be assigned to the Customer.
* `NAME`{.swift} must be alphanumeric and can contain spaces.
* `PHONE_NUMBER`{.swift} must be exactly 8 digits.
* `EMAIL`{.swift} must follow the `local@domain`{.swift} format.
* `ADDRESS`{.swift} can take any characters.

  </box>

</br>**Example:**

* `customer add --name Gabriel --phone 87654321 --email Gabrielrocks@gmail.com --address RVRC Block B`{.swift} </br>
  Adds a Customer with the name `Gabriel`{.swift}, phone number `87654321`{.swift},
  email `Gabrielrocks@gmail.com`{.swift} and address `RVRC Block B`{.swift}.

![](images/ug/customer_add.png)

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>View details of a Customer

You can view the details of a Customer by calling this command. The data displayed includes the Customer's name, phone number, email and address.

</br>**Format:** 

`customer view CUSTOMER_ID`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:** `CUSTOMER_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Customer.

  </box>

<br>**Example:**

* `customer view 1`{.swift} </br>
  Displays the details of Customer with ID `1`{.swift}.

![](images/ug/customer_view.png)

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>View a list of Customers

This command allows you to view a list of all the Customers that you have added to HomeBoss.

<br />

**Format:** `customer list`{.swift}

<br />

<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip:** You can frequently use this command together with `delivery list` to switch between the two lists.

</box>

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Find Customers

If you want to get the details of a Customer, but do not remember the Customer's full name or the Customer's ID,
you can find the Customer with this command. It finds Customers whose names has words that exactly match any of the given keywords. 

</br>**Format:** 

`customer find KEYWORD [MORE_KEYWORDS...]`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* You must provide at least one `KEYWORD`{.swift} to search for the Customer.
* You can optionally provide additional keywords, a Customer name that matches any of the given keywords will be 
  displayed.
  For example, the keywords `Alex Tan`{.swift} will display `Alex Wong`{.swift}, `Alex Tan`{.swift},
  and `Tan Ah Meng`{.swift}.
* The keyword must exactly match any word in the Customer's name. For example the keyword `Alex`{.swift} will match
  `Alex`{.swift} but not `Alexander`{.swift}.
* The search is not case sensitive.

  </box>

</br>**Example:**

* `customer find Julius Yang`{.swift} </br>
  Finds Customers whose names have words that exactly match either `Julius`{.swift} or `Yang`{.swift}.

![](images/ug/find.png)

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Update details of a Customer

This command is useful for updating the details of a Customer, such as due to a change in particulars or in the event that you keyed in the Customer's details wrongly.

</br>**Format:** 

`customer edit CUSTOMER_ID [--name NAME] [--phone PHONE_NUMBER] [--email EMAIL] [--address ADDRESS]`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* At least one of the optional fields must be provided. 
* `CUSTOMER_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Customer's ID.
* `NAME`{.swift} must be alphanumeric and can contain spaces.
* `PHONE_NUMBER`{.swift} must be exactly 8 digits.
* `EMAIL`{.swift} must follow the `local@domain`{.swift} format.
* `ADDRESS`{.swift} can take any characters.

  </box>

</br>**Examples:**

* `customer edit 1 --name Gabriel --phone 98131051`{.swift} </br>
  Edits the name of the Customer, with Customer ID of 1, to Gabriel and his phone to 98131051.
* `customer edit 2 --name Joe --email yangyang@gmail.com --address Block 10 Tampines Road`{.swift} </br>
  Edits the name of the Customer, with Customer ID of 2, to Joe, his email to yangyang@gmail.com and his address to
  Block 10 Tampines Road.


  </br>

[&uarr; Back to Table of Contents](#table-of-contents)
</br>

### </br></br>Delete a Customer

You can delete any Customer who no longer require your services by calling this command.

</br>**Format:** 

`customer delete CUSTOMER_ID`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:** `CUSTOMER_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Customer.

</box>

<br/>

<box background-color="#f2dede" border-color="#ebccd1" type="warning" icon=":exclamation:">

**Warning:** Be careful! All Deliveries associated with the Customer will also be deleted. You won't be able to undo this deletion!
</box>

</br>**Example:**

* `customer delete 1`{.swift} </br>
  Deletes the Customer with ID 1.

</br>

[&uarr; Back to Table of Contents](#table-of-contents)
</br>

## </br><span style="text-decoration:underline;"><strong>Delivery</strong></span>

### Add a Delivery

By using this command, you can incorporate Deliveries associated with your Customers into HomeBoss. Adding a Delivery is the initial step that later enables you to monitor the Delivery's status and other relevant details with our suite of Delivery-related commands.

<br/>

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

Deliveries consist of a Delivery Name, a Customer ID, an Order Date, a Delivery Date, a Delivery Status and 
an Address to ship to. </br> </br>
You don't have to fill in Order Date, Delivery Status and Address. Instead they will be initialised with these values: 

- Order Date: Today's date
- Delivery Status: CREATED
- Address: Customer's Address

Delivery Status can be one of CREATED, SHIPPED, COMPLETED, CANCELLED.

</box>

</br>**Format:** 

`delivery add DELIVERY_NAME --customer CUSTOMER_ID --date EXPECTED_DELIVERY_DATE`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* `DELIVERY_NAME`{.swift} must be alphanumeric and can contain spaces.
* `CUSTOMER_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Customer.
* `EXPECTED_DELIVERY_DATE`{.swift} must be today or after today's date in yyyy-MM-dd format.

  </box>

</br>**Example:**

- `delivery add Chocolate Cake --customer 1 --date 2023-12-12`{.swift} </br>
  Adds a Delivery with Delivery Name Chocolate Cake, with the Customer who has Customer ID 1, with Delivery Date
  of 2023-12-12, Order Date will be today's date, Delivery Status will be CREATED and Address will be the Customer's
  Address. 

![](images/ug/delivery_add.png)

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>View details of a Delivery

You can view the details of a Delivery by calling this command. The data displayed includes the Delivery's name, status, Customer, Customer ID, address, order date, expected delivery date and notes (if any).

</br>**Format:** 

`delivery view DELIVERY_ID`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:** `DELIVERY_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Delivery.

  </box>

</br>**Example:**

* `delivery view 1`{.swift} </br>
  Displays the details of Delivery with ID `1`{.swift}.

![](images/ug/delivery_view.png)

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>View a list of Deliveries

This command allows you to view a list of all the Deliveries that you have added to HomeBoss. This is a more powerful command than `customer list`{.swift}, as it allows you to filter the list of Deliveries by status, customer ID and/or expected delivery date. This command also allows you to sort the list of Deliveries by expected delivery date in either ascending or descending order. By default, the list of Deliveries will be sorted by expected delivery date in descending order (latest first).

</br>**Format:**

`delivery list [--status STATUS] [--customer CUSTOMER_ID] [--date EXPECTED_DELIVERY_DATE]  [--sort SORT]`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* `STATUS`{.swift} accepts the following values: `CREATED`{.swift}/`SHIPPED`{.swift}/`COMPLETED`{.swift}/
  `CANCELLED`{.swift}.
* `CUSTOMER_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Customer.
* `EXPECTED_DELIVERY_DATE`{.swift} must be today or after today's date in yyyy-MM-dd format OR
  `TODAY`{.swift} for today’s date.
* `SORT`{.swift} accepts the following values: `ASC`{.swift}/`DESC`{.swift}.
  
  </box>

<br />

<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip:**
You may combine any of the filters and sort options to get the list of Deliveries that you want.
</box>

</br>**Examples:**

* `delivery list --status CREATED --customer 1 --sort DESC`{.swift} </br>
  Lists all Deliveries with status `CREATED`{.swift} for Customer with ID `1`{.swift} with expected delivery date in
  descending order.

* `delivery list --status SHIPPED --date TODAY`{.swift} </br>
  Lists all Deliveries with status `SHIPPED`{.swift} for all Customers and expected delivery date of today.

![](images/ug/delivery_list.png)

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Find Deliveries

If you cannot remember the full name of a Delivery, you can find the Delivery with this command. It finds Deliveries whose names has words that exactly match any of the given keywords.

</br>**Format:** 

`delivery find KEYWORD [MORE_KEYWORDS...]`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* You must provide at least one alphanumeric `KEYWORD`{.swift} to search for the Delivery.
* You can optionally provide additional keywords, a Delivery that matches any of the given keywords will be displayed.
  For example, the keywords `Chocolate Bun`{.swift} will display `Chocolate Cake`{.swift}, `Chocolate Bun`{.swift},
  and `Strawberry Bun`{.swift}.
* The keyword must exactly match any word in the delivery name. For example, the keyword `Straw`{.swift} will match
  `Straw`{.swift} but not `Strawberry`{.swift}.
* The search is not case sensitive.

  </box>

</br>**Example:**
* `delivery find Gambes Banana`{.swift} </br>
Find all Deliveries whose name has words that exactly match `Gambes`{.swift} or `Banana`{.swift}

![](images/ug/delivery_find.png)

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

#### </br></br>Update details of a Delivery

This command is useful for updating the details of a Delivery, such as due to a change in the details of a Delivery or in the event that you keyed in the Delivery's details wrongly.

</br>**Format:** 

`delivery edit DELIVERY_ID [--name DELIVERY_NAME] [--customer CUSTOMER_ID] [--date EXPECTED_DELIVERY_DATE][--status STATUS] [--note NOTE]`{.swift}

<br />

<box background-color="#f2dede" border-color="#ebccd1" type="warning" icon=":exclamation:">

**Warning:** Be careful! You won't be able to undo this edit action!

</box>

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* At least one of the optional fields must be provided.
* `DELIVERY_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Delivery.
* `DELIVERY_NAME`{.swift} must be alphanumeric and can contain spaces.
* `CUSTOMER_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Customer.
* `EXPECTED_DELIVERY_DATE`{.swift} must be today or after today's date in yyyy-MM-dd format.
* `STATUS`{.swift} accepts the following values: `CREATED`{.swift}/`SHIPPED`{.swift}/`COMPLETED`{.swift}/`CANCELLED`{.swift}.
* `NOTE`{.swift} must be alphanumeric and can contain spaces.

  </box>
  
<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip:** 
* If you only want to update the Delivery's status, simply use `delivery status`{.swift} instead. </br>

* If you only want to update the Delivery's note, simply use `delivery note`{.swift} instead.
</box>

</br>**Examples:**

- `delivery edit 1 --status CANCELLED --note Sudden overseas business trip to attend to.`{.swift} </br>
  Edits the Delivery's status of the Delivery, with Delivery ID of 1, to `CANCELLED`{.swift} and edits the note of the 
  Delivery.
  (If Delivery does not have a note, a note will be created to the Delivery)
- `delivery edit 2 --name Vanilla Cake --customer 3`{.swift} </br>
  Edits the name of the Delivery, with Delivery ID of 2, to Vanilla Cake and edits the Customer of the 
  Delivery to the Customer with ID of 3.

  <br/>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Update status of a Delivery

An order can have one of the following statuses: CREATED, SHIPPED, COMPLETED or CANCELLED. This command allows you to update the status of a Delivery to any of the aforementioned statuses, according to the progress of the Delivery for your easy tracking.

</br>**Format:** `delivery status DELIVERY_ID STATUS`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* `DELIVERY_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Delivery.
* `STATUS`{.swift} accepts the following values: `CREATED`{.swift}/`SHIPPED`{.swift}/`COMPLETED`{.swift}/
`CANCELLED`{.swift}.

  </box>

</br>**Examples:**
* `delivery status 1 CANCELLED`{.swift} </br>
  Updates the status of Delivery with ID `1`{.swift} to `CANCELLED`{.swift}.
* `delivery status 2 SHIPPED`{.swift} </br>
  Updates the status of Delivery with ID `2`{.swift} to `SHIPPED`{.swift}.

<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip:** Delivery status is not case sensitive. You can type `created`{.swift} instead of `CREATED`{.swift} and it will still work.
</box>

<br/>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Create a note for a Delivery

If you would like to create a note about a specific delivery, this command allows you to do so as a shortcut, as opposed to using the lengthier `delivery edit`{.swift} command.

</br>**Format:** 

`delivery note DELIVERY_ID --note NOTE`{.swift}

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* If the Delivery already has a Note, the previous Note will be overwritten by the new given Note.
* `DELIVERY_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Delivery's ID.
* `NOTE`{.swift} must be alphanumeric and can contain spaces.
  
  </box>

</br>**Example:**

* `delivery note 1 --note By FedEx`{.swift} </br>
  Creates a new Note "By FedEx" for the Delivery with ID `1`{.swift}

<br/>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Delete a Delivery

If you feel that a Delivery is no longer relevant (i.e., cancelled or completed), you can delete it from HomeBoss using this command.

</br>**Format:** 

`delivery delete DELIVERY_ID`{.swift}

<box background-color="#f2dede" border-color="#ebccd1" type="warning" icon=":exclamation:">

**Warning:**

Be careful! This action is irreversible. Once deleted, the delivery cannot be recovered.

</box>

<br />

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:**

* `DELIVERY_ID`{.swift} must be an integer greater than 0 that corresponds to an existing Delivery.

  </box>


</br>**Example:**

- `delivery delete 1`{.swift} </br>
  Deletes Delivery 1 from the delivery database.

  <br/>

[&uarr; Back to Table of Contents](#table-of-contents)

## </br><span style="text-decoration:underline;"><strong>Miscellaneous</strong></span>

### Help

This command allows you view a summary of the commands available, the format of the commands, and a link to this user guide.

<br/>

**Format:** `help`{.swift}

<br/>

<box type="tip" background-color="#d9edf7" border-color="#bce8f1" icon=":bulb:">

**Tip:** You can access this command anytime when using the application, even when you are not logged in.
  </box>

![](images/ug/help.png)

<br/>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Exit

You can exit the program by calling this command.

**Format:** `exit`{.swift}

<box type="note" background-color="#dff0d8" border-color="#d6e9c6" icon=":information_source:">

**Note:** If you are logged in, this command will automatically log you out of your account and close the application.
  </box>

</br>

[&uarr; Back to Table of Contents](#table-of-contents)

### </br></br>Clear

In the event that you want to perform a complete reset of HomeBoss' Customer and Delivery database, you can easily clear all your Customer and Delivery data by calling this command.

**Format:** `clear`{.swift}

<br/>

<box type="warning" background-color="#f2dede" border-color="#ebccd1" icon=":exclamation:">

**Warning:** Be careful, this action is irreversible! All your Customer and Delivery data will be deleted permanently.
  Proceed with caution!
  
  </box>


<br/>

[&uarr; Back to Table of Contents](#table-of-contents)

# </br>FAQ

**Q: Where do I get support for HomeBoss?**

A: You can raise an issue on our [GitHub repository](https://github.com/AY2324S1-CS2103T-T13-3/tp/issues)

**Q: How do I report a bug?**

A: You can raise a bug report on our [GitHub repository](https://github.com/AY2324S1-CS2103T-T13-3/tp/issues)

**Q: How do I import my data from another software?**

A: You can import your data by converting your data into .json in the format of the Customer and Delivery data in the
data folder.

**Q: How do I export my data to another software?**

A: It is currently not possible to export your data to another software.

**Q: Why is there an error when I input non-English characters?**

A: HomeBoss only supports English characters.

# </br>Command Summary

#### User

| Command  | Format                                                                                                                               | Examples                                                                                                                          |
|----------|--------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| Register | `register --user USERNAME --password PASSWORD --confirmPass CONFIRM_PASSWORD --secretQn SECRET_QUESTION --answer ANSWER`{.swift}     | `register --user Gabriel --password GabrielIsGreat --confirmPass GabrielIsGreat --secretQn First Pet Name? --answer Koko`{.swift} |
| Login    | `login --user USERNAME --password PASSWORD`{.swift}                                                                                  | `login --user Gabriel --password GabrielIsGreat`{.swift}                                                                          |
| Update   | `update [--user USERNAME] [--password PASSWORD --confirmPass CONFIRM_PASSWORD] [--secretQn SECRET_QUESTION --answer ANSWER]`{.swift} | `update --user GabrielV2 --password GabrielIsBest --confirmPass GabrielIsBest --secretQn Favourite Pet --answer BoBo`{.swift}     |
| Recover  | `recover account [--answer ANSWER --password NEW_PASSWORD --confirmPass CONFIRM_PASSWORD]`{.swift}                                   | `recover account --answer Koko --password NewPassword123 --confirmPass NewPassword123`{.swift}                                    |
| Logout   | `logout`{.swift}                                                                                                                     | `logout`{.swift}                                                                                                                  |
| Delete   | `delete account`{.swift}                                                                                                             | `delete account`{.swift}                                                                                                          |

<br>

#### Customer

| Command | Format                                                                                                       | Examples                                                                                                                 |
|---------|--------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| Add     | `customer add --name NAME --phone PHONE_NUMBER --email EMAIL --address ADDRESS`{.swift}                      | `customer add --name Gabriel --phone 87654321 --email Gabrielrocks@gmail.com --address RVRC Block B`{.swift}             |
| View    | `customer view CUSTOMER_ID`{.swift}                                                                          | `customer view 1`{.swift}                                                                                                |
| List    | `customer list`{.swift}                                                                                      | `customer list`{.swift}                                                                                                  |
| Find    | `customer find KEYWORD [MORE_KEYWORDS]`{.swift}                                                              | `customer find Julius Yang`{.swift}                                                                                      |
| Edit    | `customer edit CUSTOMER_ID [--name NAME] [--phone PHONE_NUMBER] [--email EMAIL] [--address ADDRESS]`{.swift} | `customer edit 1 --name Gabriel --phone 12345678 --email Gabrielrock@gmail.com --address Block 10 Tampines Road`{.swift} |
| Delete  | `customer delete CUSTOMER_ID`{.swift}                                                                        | `customer delete 1`{.swift}                                                                                              |

<br>

#### Delivery

| Command | Format                                                                                                                                     | Examples                                                                                                                           |
|---------|--------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| Add     | `delivery add DELIVERY_NAME --customer CUSTOMER_ID --date DELIVERY_DATE`{.swift}                                                           | `delivery add furniture --customer 5 --date 2023-12-03`{.swift}                                                                    |
| View    | `delivery view DELIVERY_ID`{.swift}                                                                                                        | `delivery view 1`{.swift}                                                                                                          |
| List    | `delivery list [--status STATUS] [--customer CUSTOMER_ID] [--date DELIVERY_DATE] [--sort SORT]`{.swift}                                    | `delivery list --status created --customer 1 --date 2023-12-12 --sort desc`{.swift}                                                |
| Find    | `delivery find KEYWORD [MORE_KEYWORDS]`{.swift}                                                                                            | `delivery find Chocolate Bun`{.swift}                                                                                              |
| Edit    | `delivery edit DELIVERY_ID [--name DELIVERY_NAME] [--customer CUSTOMER_ID] [--date DELIVERY_DATE] [--status STATUS] [--note NOTE]`{.swift} | `delivery edit 1 --name Chocolate Cake --customer 2 --date 2024-12-12 --status CANCELLED --note Customer changed his mind`{.swift} |
| Status  | `delivery status DELIVERY_ID STATUS`{.swift}                                                                                               | `delivery status 2 completed`{.swift}                                                                                              |
| Note    | `delivery note DELIVERY_ID --note NOTE`{.swift}                                                                                            | `delivery note 1 --note By FedEx`{.swift}                                                                                          |
| Delete  | `delivery delete DELIVERY_ID`{.swift}                                                                                                      | `delivery delete 1`{.swift}                                                                                                        |

<br>

#### Miscellaneous

| Command | Format          | Examples        |
|---------|-----------------|-----------------|
| Exit    | `exit`{.swift}  | `exit`{.swift}  |
| Help    | `help`{.swift}  | `help`{.swift}  |
| Clear   | `clear`{.swift} | `clear`{.swift} |
