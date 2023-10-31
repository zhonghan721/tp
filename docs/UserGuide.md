# User Guide for HomeBoss

This comprehensive user guide is your key to a seamless start with our cutting-edge software designed specifically for
home-based businesses. Our solution is tailored to enhance the efficiency of managing delivery addresses, simplifying
your operations.

---

### Navigating the User Guide

**Note Box**
<div markdown="span" class="alert alert-info">:information_source: **Note:** Provides information that is useful to know.
</div>

**Tip Box**
<div markdown="span" class="alert alert-success">:bulb: **Tip:** Provides information that can help enhance the user experience but is not necessary to know.
</div>

**Warning Box**
<div markdown="span" class="alert alert-danger">:exclamation: **Warning:** Important information to take note of to avoid any unintended effects!
</div>

---

# Table of Contents

- Getting Started
- Features
    - User
        - [Register](#register)
        - [Login](#login)
        - Update details
        - Logout
        - [Account recovery](#account-recovery)
        - [Account deletion](#account-deletion)
    - Customer
        - Add customer
        - Search for a customer [Coming Soon]
        - List customers
        - Update customer details
        - [Delete customer](#delete-customer)
    - Delivery
        - Create delivery
        - View all deliveries
        - View details of deliveries
        - Update delivery status and date
        - Delete delivery
        - Create a note for a delivery
        - View deliveries for the day [Coming Soon]
        - Add customer data to delivery [Coming Soon]
        - Remove customer from delivery [Coming Soon]
        - Look up delivery details [Coming Soon]
- Troubleshooting / FAQ

---

# Getting Started

To get started, you will need to create an account and download the software. Once you have done that, you can follow
the instructions in the Getting Started Guide to start using the software.

---

# Command Summary

Here is a brief introduction to the commands that you will be using in HomeBoss. For more detailed information, please
refer to the [Features](#features) section.

### User

_These are commands for managing your user account in HomeBoss._

- `register` - Registers a new user account to use HomeBoss.
- `login` - Logs in to your user account.
- `update` - Updates your user account details.
- `logout` - Logs out of your user account.
- `recover account` - Recovers your user account.
- `delete account` - Deletes your user account.

### Customer

_These are commands for managing your customers in HomeBoss._

- `customer add` - Adds a customer to the address book.
- `customer find` - Finds customers whose names contain any of the given keywords.
- `customer list` - Lists all customers in the address book.
- `customer edit` - Updates the details of an existing customer in the address book.
- `customer delete` - Deletes the specified customer from the address book.

### Delivery

_These are commands for managing your deliveries in HomeBoss._

- `delivery add` - Adds a delivery to the delivery book.
- `delivery list` - Lists all deliveries in the delivery book.
- `delivery view` - Shows the details of the specified delivery.
- `delivery status` - Changes the status of a specified delivery.
- `delivery note` - Creates a note for a specified delivery.
- `delivery delete` - Deletes the specified delivery from the delivery book.

### Miscellaneous

_These are general commands for using HomeBoss._

- `help` - Shows a list of commands and their usage.
- `exit` - Exits the program.
- `clear` - Clears both customer and delivery database. **Warning:** This action is irreversible.

---

# Features

\*[ ] specifies optional fields

## <span style="text-decoration:underline;">User</span>

### Register

> Registers a new user account to use HomeBoss.

_Want to get started? Start by registering for an account to use HomeBoss! Note that only one account can be registered
at a time._

**Format:
** `register --user USERNAME --password PASSWORD --confirmPass CONFIRM_PASSWORD --secretQn SECRET_QUESTION --answer ANSWER`

**Example:
** `register --user gabriel --password gabrielIsGreat --confirmPass gabrielIsGreat --secretQn First pet's name? --answer Koko`

<div markdown="span" class="alert alert-info">:information_source: **Note:** All fields are required.
</div>

<ins>Before
![](images/user/user_freshStart.png)
<ins>After
![](images/user/userRegister_after.png)
[&uarr; Back to Table of Contents](#table-of-contents)

### Login

**Format:** `login --user USERNAME --password PASSWORD`

**Example:** `login --user gabriel --password gabrielIsGreat`

**Accepted Values:**

_USERNAME:_ String, consisting of only alphanumeric characters

_PASSWORD:_ String, consisting of at least 8 alphanumeric characters

**Command succeeds:** _Log in successful._

**Command fails (missing fields):** _Please fill up all the required fields._

**Command fails (wrong login credentials):** _Wrong username and/or password. Try again._

### Update details

**Format:** `update [--user USERNAME] [--password PASSWORD --confirmPass CONFIRM_PASSWORD]
[--secretQn SECRET_QUESTION --answer ANSWER]`

**Example:** `login --user gabrielV2 --password gabrielIsBest --confirmPass gabrielIsBest
--secretQn Favourite Pet --answer BoBo`

**Accepted Values:**

_USERNAME:_ String, consisting of only alphanumeric characters

_PASSWORD:_ String, consisting of at least 8 alphanumeric characters

_CONFIRM\_PASSWORD:_ String that is the same as _PASSWORD_

_SECRET\_QUESTION:_ String

_ANSWER:_ String

*At least one of the optional fields must be provided.
If PASSWORD is provided, CONFIRM_PASSWORD must also be provided, vice versa.
If SECRET_QUESTION is provided, ANSWER must also be provided, vice versa.
The details will be updated without checking against the current details.

**Command succeeds:** _Update successful._

**Command fails (missing fields):** _Please provide at least one field to update!_

**Command fails (passwords do not match):** _Passwords do not match. Try again._

**Command fails (only one of password/confirm password is provided):**
_Password and Confirm Password have to be either all present or all absent. Try again._

**Command fails (only one of secret question/answer is provided):**
_Secret Question and Answer have to be either all present or all absent. Try again._

### Logout

**Format:** `logout`

**Example:** `logout`

### Account Recovery

> Recovers the user account.

_Forgot your password? Use this command to recover your account!_

**Format:** `recover account [--answer ANSWER --password NEW_PASSWORD --confirmPass CONFIRM_PASSWORD]`

**Examples:**

- `recover account`</br>
- `recover account --answer Koko --password newPassword123 --confirmPass newPassword123`</br>

<div markdown="span" class="alert alert-info">:information_source: **Note:** [] around a group of parameters indicates that it is optional, but all parameters within the group must be provided.
</div>

<ins>After (without optional fields)
![](images/user/userRecoverAccount_after_secretQn.png)
<ins>After (with optional fields)
![](images/user/userRecoverAccount_after.png)
[&uarr; Back to Table of Contents](#table-of-contents)

### Account Deletion

> Deletes the user account.

_Want to delete your account? Call this command to delete your account and clear all your data._

<div markdown="span" class="alert alert-success">:bulb: **Tip:** This command is useful only as a last resort, should you forget your password and secret answer. However, if you forgot your password but remember the answer to your secret question, you can call `recover account` [here](#account-recovery) instead.
</div>

**Format:** `delete account`

<ins>Before
![](images/customer/customerList.png)
<ins>After
![](images/user/userDelete_after.png)
[&uarr; Back to Table of Contents](#table-of-contents)

## <span style="text-decoration:underline;">Customer</span>

### Add a customer

Adds a customer to the address book.

**Format:** `customer add --name NAME --phone PHONE_NUMBER --email EMAIL --address ADDRESS`

**Example:** `customer add --name Gabriel --phone 87654321 --email gabrielrocks@gmail.com --address RVRC Block B`

**Accepted Values:**

_NAME_: String

_PHONE_NUMBER_: 8 digit Integer

_EMAIL_: String with @ and . in valid email format

_ADDRESS_: String

**Command succeeds:** _Customer 1, Gabriel added._

**Command fails (missing field):** _Please fill up all the required fields (--name NAME --phone PHONE_NUMBER --email
EMAIL --address ADDRESS)._

### Find customers

You can find customers whose names have a word that matches _ANY_ of the given keywords.

**Format:** `customer find KEYWORD [MORE_KEYWORDS]`

**Example:** `customer find Ibrahim Yu`

**Accepted Values:**

_KEYWORD_: One word

_MORE\_KEYWORDS_: More _KEYWORDs_ separated by spaces

**Command succeeds:**

//TODO: Add image

**Command fails (missing_keyword):** _Please provide at least one keyword to search for!_

### List customers

Lists all the customers added in the address book.

**Format:** `customer list`

**Example:** `customer list`

**Accepted Values:**

_NIL_

**Command succeeds (>0 customers):**

![](images/customer/customerList.png)

**Command succeeds (0 customer):** _There are currently no customers!_

_Details coming soon..._

### Update customer details

Updates the personal details of an existing customer in the address book.

**Format:** `customer edit CUSTOMER_ID [--name NAME] [--phone PHONE_NUMBER] [--email EMAIL] [--address ADDRESS]`

**Example:
** `customer edit 1001 --name Gabriel -–phone 1234 5678 --email gabrielSoCool@gmail.com --address RVRC Block B Ben's Room`

**Accepted Values:**

_NAME_: String

_PHONE_NUMBER_: 8 digit Integer

_EMAIL_: String with @ and . in valid email format

_ADDRESS_: String

_CUSTOMER_ID_: Integer

*At least one of the optional fields must be provided.

**Command succeeds:** _Customer 1, Gabriel has been updated!_

**Command fails (missing_index):** _Please specify the customer to update._

**Command fails (invalid_index):** _The customer does not exist!_

**Command fails (missing_fields):** _Please provide at least one field to update!_

### Delete customer

> Deletes the specified customer from the customer database. All deliveries associated with the customer will also be
> deleted.

_Want to delete a customer? Call this command to delete a customer from the customer database._

**Format:** `customer delete CUSTOMER_ID`

**Example:** `customer delete 1`

<ins>Before
![](images/customer/customerList.png)
<ins>After
![](images/customer/customerDelete_after.png)
[&uarr; Back to Table of Contents](#table-of-contents)

## <span style="text-decoration:underline;">Delivery</span>

### Add delivery

Adds a delivery to the delivery book.

**Format:** `delivery add DELIVERY_NAME --customer CUSTOMER_ID --date DELIVERY_DATE`

**Example:** `delivery add furniture --customer 5 --date 2023-12-03`

**Accepted Values:**

_DELIVERY_NAME:_ String of 50 characters

_CUSTOMER_ID:_ Integer

_DELIVERY_DATE:_ Delivery Date String in yyyy-MM-dd format or `today` for today’s date

**Command succeeds:** _Delivery [1001] furniture created successfully for Customer 1, Gabriel!_

**Command fails (missing_fields):** _Please fill up all the required fields (DELIVERY_NAME --customer CUSTOMER_ID --date
DELIVERY_DATE)!_

**Command fails (invalid_date):** _Delivery Date cannot be before today!_

**Command fails (invalid_date_format):** _Please provide the date in the format: yyyy-MM-dd._

### View all deliveries

Shows a list of all deliveries.

**Format:** `delivery list [--status STATUS] [--customer CUSTOMER_ID] [--date DELIVERY_DATE]  [--sort SORT]`

**Example:** `delivery list --status created --customer 1 --date 2023-12-12 --sort desc`

**Accepted Values:**

_STATUS_: CREATED/SHIPPED/COMPLETED/CANCELLED. If unspecified, defaults to show all deliveries.

_CUSTOMER_ID_: Integer

_DELIVERY_DATE_: Delivery Date String in yyyy-MM-dd format or `today` for today’s date

_SORT_: String of either `asc` for ascending or `desc` for descending or defaults to sort by delivery date.

**Command succeeds (>0 deliveries):**
![](images/delivery/delivery_list.png)

**Command failed (0 deliveries):** _There are currently no deliveries!_

### View details of deliveries

Shows the details of the specified delivery.

**Format:** `delivery view DELIVERY_ID`

**Example:** `delivery view 1001`

**Accepted Values:**

_DELIVERY_ID_: Integer

**Command succeeds:**

![](images/delivery/delivery_view.png)

**Command failed (0 deliveries):** _There are currently no deliveries._

### Look up delivery details `[Coming Soon in v1.3]`

_Details coming soon..._

### Update delivery status

Changes the status of a specified delivery

**Format:** `delivery status STATUS CUSTOMER_ID`

**Example:** `delivery status completed 2`

**Accepted Values:**

_STATUS:_ Either `CREATED`/`SHIPPED`/`COMPLETED`/`CANCELLED`

_CUSTOMER_ID:_ Integer

**Command succeeds:**

![Delivery Status](images/delivery/delivery_status.png)
**Command fails (invalid_status):** _Delivery Status should be one of CREATED, SHIPPED, COMPLETED, CANCELLED_

**Command fails (invalid_index):** _The delivery index provided is invalid_

**Command fails (missing_fields):**

_Invalid command format!_<br />
_delivery status: Edits the status of the delivery identified by the ID of the delivery. Existing status will be
overwritten by the input status._<br />
_Parameters: STATUS (must be one of CREATED/SHIPPED/COMPLETED/CANCELLED) ID (must be a integer representing a valid
ID)_<br />
_Example: delivery status COMPLETED 1_<br />

#### Update delivery details

Updates the delivery details of an existing delivery in the delivery book.

**Format:** `delivery edit DELIVERY_ID [--name DELIVERY_NAME] [--customer CUSTOMER_ID] [--date DELIVERY_DATE]
[--status STATUS] [--note NOTE]`

**Example:** `delivery edit 1001 --name Chocolate Cake --customer 2 --date 2024-12-12 --status CANCELLED --note
Customer changed his mind.`

**Accepted Values:**

_DELIVERY_ID:_ Integer

_DELIVERY_NAME:_ String

_CUSTOMER_ID:_ Integer

_DELIVERY_DATE:_ Delivery Date String in yyyy-MM-dd format or `today` for today’s date

_STATUS:_ Either `CREATED`/`SHIPPED`/`COMPLETED`/`CANCELLED`

_NOTE:_ String

**Command succeeds:**
//TODO: Add image

**Command fails (missing_index):** _Invalid command format!_

**Command fails (invalid_index):** _The delivery index provided is invalid_

**Command fails (missing_fields):** _Please provide at least one field to update!_

### Create a note for a delivery

Creates a note for a specified delivery

**Format:** `delivery note DELIVERY_ID --note NOTE`

**Example:** `delivery note 1 --note By FedEx`

**Accepted Values:**

_DELIVERY_ID_: Integer

_NOTE_: Nonempty alphanumeric string

**Command succeeds:**

![Delivery Note](images/delivery/delivery_note.png)

**Command failed (invalid_index):** _The delivery index provided is invalid_

**Command failed (invalid_note):** _Note should not be empty_

**Command failed (missing_fields):**

_Invalid command format!_</br>
_delivery note: Adds a note to the delivery identified by the ID of the delivery. Existing note if any will be replaced
with the input note._</br>
_Parameters: DELIVERY_ID (must be a integer representing a valid ID) --note Note_</br>
_Example: delivery note 1 --note This is a note_</br>

### Add customer data to delivery `[Coming Soon in v1.3]`

_Details coming soon..._

### Delete delivery

Deletes the specified delivery.

**Format:** `delivery delete DELIVERY_ID`

**Example:** `delivery delete 1001`

**Accepted Values:**

_DELIVERY_ID_: Integer

**Command succeeds:** _Delivery [1001] Gabriel’s Milk deleted!_

**Command failed (delivery_id missing):** _Please specify a delivery id to delete!_

**Command failed (delivery_id not in database):** _This delivery does not seem to exist!_

### Remove customer from delivery `[Coming Soon in v1.3]`

_Details coming soon..._
