# User Guide 

# About HomeBoss

HomeBoss is a desktop application for **home-based business owners** to **manage their customers and deliveries**. 
HomeBoss streamlines the process of your operations, optimises your resources, and enhances your overall business 
experience. 

With our application, you will be able to: 
* Keep track of the details of your customers and deliveries
* Search for a particular customer/delivery easily
* Organise your data in a neat and tidy manner by filtering and sorting to your needs </br>
</br>
and much more!

All these are done to improve your efficiency and productivity all while being incredibly simple to use.
HomeBoss is also **optimised for fast typist with the use of a Command Line Interface (CLI)**, allowing you to 
execute commands quickly. On top of that, we utilise a *Graphical User Interface (GUI)* to let you view your 
data in a neater and more organised manner. 

Essentially, with HomeBoss, you can **focus on what matters most: running your business**.



# Table of Contents

* 1\. Introduction 
  * 1.1 About HomeBoss
  * 1.2 About this User Guide
  * 1.3 Navigating the User Guide
* 2\. Table of Contents 
* 3\. Quick Start Guide 
  * 2.1 Installation 
* 4\. Features
  * 4.1 User
    * 4.1.1 Register 
    * 4.1.2 Login
    * 4.1.3 Update details
    * 4.1.4 Logout
    * 4.1.5 Account recovery
    * 4.1.6 Account deletion
  * 4.2 Customer 
    * 4.2.1 Add customer
    * 4.2.2 Search for a customer 
    * 4.2.3 List customers
    * 4.2.4 Update customer details
    * 4.2.5 Delete customer
  * 4.3 Delivery
    * 4.3.1 Add delivery
    * 4.3.2 View all deliveries
    * 4.3.3 View details of deliveries
    * 4.3.4 Update details of delivery
    * 4.3.5 Create a note for a delivery 
    * 4.3.6 Delete delivery
* 5\. FAQ
* 6\. Command Summary
* 7\. Glossary


# Getting Started

To get started, you will need to create an account and download the software. Once you have done that, you can follow
the instructions in the Getting Started Guide to start using the software.

# Features

\*[ ] specifies optional fields

## <span style="text-decoration:underline;">User</span>

### Register

You can register for an account to use HomeBoss. Only one account can be registered at a time.

**Format:
** `register --user USERNAME --password PASSWORD --confirmPass CONFIRM_PASSWORD --secretQn SECRET_QUESTION --answer ANSWER`

**Example:
** `register --user gabriel --password gabrielIsGreat --confirmPass gabrielIsGreat --secretQn First pet's name? --answer Koko`

**Accepted Values:**

_USERNAME:_ String, consisting of only alphanumeric characters

_PASSWORD:_ String, consisting of at least 8 alphanumeric characters

_CONFIRM\_PASSWORD:_ String that is the same as _PASSWORD_

_SECRET\_QUESTION:_ String

_ANSWER:_ String, not case sensitive

**Command succeeds:** _Registration successful._

**Command fails (missing fields):** _Please fill up all the required fields._

**Command fails (password does not match):** _Passwords do not match. Try again._

**Command fails (missing secret question and answer):** _Please key in a secret question and answer for account
recovery. Try again._

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

**Format:** `recover account [--answer ANSWER --password NEW_PASSWORD --confirmPass CONFIRM_PASSWORD]`

**Example 1:** `recover account`</br>
**Example 2:** `recover account --answer Koko --password newPassword123 --confirmPass newPassword123`</br>

**Accepted Values:**

_ANSWER:_ String, not case sensitive

_NEW\_PASSWORD:_ String

_CONFIRM\_PASSWORD:_ String that is the same as _NEW\_PASSWORD_

*`--answer`, `--password`, and `--confirmPass` flags have to be either all present or all absent.

**Command succeeds (without flags):** _Your secret question is: \<previously stored secret qn\>._

**Command succeeds (with flags):** _Your account has been recovered successfully. Welcome back to HomeBoss._

**Command fails (missing fields):** _Please fill up all the required fields._

**Command fails (wrong answer to secret question):** _Wrong answer to secret question. Either try again or
call `delete account` (permanent loss of stored data)._

**Command fails (password does not match):** _Passwords do not match. Try again._

### Account Deletion

**Format:** `delete account`

**Example:** `delete account`

**Command succeeds:** _User deleted successfully._

**Command fails (no user registered):** _No accounts found. Please register an account first._

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

![](images/customer/customer_list.png)

**Command succeeds (0 customer):** _There are currently no customers!_

_Details coming soon..._

### Update customer details
>Updates the personal details of an existing customer in the address book.

Did you accidentally key in the wrong details for a customer? Or perhaps your customer has changed his particulars? No
worries! You can  edit the details of a customer simply by calling this command.

**Format:** `customer edit CUSTOMER_ID [--name NAME] [--phone PHONE_NUMBER] [--email EMAIL] [--address ADDRESS]`

<div style="padding: 15px; border: 1px solid transparent; border-color: transparent; margin-bottom: 20px; border-radius: 4px; color: #3c763d; background-color: #dff0d8; border-color: #d6e9c6;">
[!Note] [ ] around a parameter indicates that it is optional.
</div>

**Examples:**
- `customer edit 1 --name Gabriel -–phone 9813 1051` </br>
  Edits customer 1's name to Gabriel and phone to 9813 1051.
- `customer edit 2 --name Joe --email yangyang@gmail.com -–address Block 10 Tampines Road` </br>
  Edits customer 2's name to Joe, email to yangyang@gmail.com and address to Block 10 Tampines Road.\
  **Before:**
  ![Screenshot 2023-10-31 at 2.31.41 AM.png](..%2F..%2FScreenshot%202023-10-31%20at%202.31.41%20AM.png)
**After:**
  ![Screenshot 2023-10-31 at 2.38.29 AM.png](..%2F..%2FScreenshot%202023-10-31%20at%202.38.29%20AM.png)
  [&uarr; Back to Table of Contents](#top)


### Delete customer

Deletes the specified customer from the address book.

**Format:** `customer delete CUSTOMER_ID`

**Example:** `customer delete 1001`

**Accepted Values:**

_CUSTOMER_ID:_ Integer

**Command succeeds:** _Customer 1, Gabriel has been deleted!_

**Command fails (missing_index):** _Please specify the customer to delete._

**Command fails (invalid_index):** _The customer does not exist!_

**Command fails (pending_delivery_customer_index):** _Delivery for Customer 1, Gabriel is not completed yet!_

## <span style="text-decoration:underline;">Delivery</span>

### Add delivery

>Adds a delivery to the delivery book.

HomeBoss' most essential feature. The whole premise of our application is so that you can easily track your 
deliveries/orders. With this feature, you can do just that by adding a delivery to the delivery book.

<div style="padding: 15px; border: 1px solid transparent; border-color: transparent; margin-bottom: 20px; border-radius: 4px; color: #3c763d; background-color: #dff0d8; border-color: #d6e9c6;">
[!Note] Deliveries consist of a Delivery Name, a Customer ID, an Order Date, a Delivery Date, a Delivery Status and 
an Address to ship to. </br> </br>
You don't have to fill in Order Date, Delivery Status and Address. Instead they will be initialised with these values: 

- Order Date: Today's date
- Delivery Status: CREATED
- Address: Customer's Address

Cool huh! We try to help you speed up the process as much as possible.
 
</div>

<div style="padding: 15px; border: 1px solid transparent; border-color: transparent; margin-bottom: 20px; border-radius: 4px; color: #31708f; background-color: #d9edf7; border-color: #bce8f1;">
[!Tip] Delivery Status can be one of CREATED, SHIPPED, COMPLETED, CANCELLED. 
</div>
 
**Format:** `delivery add DELIVERY_NAME --customer CUSTOMER_ID --date DELIVERY_DATE`

**Example:**
- `delivery add Chocolate Cake --customer 1 --date 2023-12-12` </br>
  Adds a delivery with Delivery Name Chocolate Cake, with the Customer who has Customer ID 1, with Delivery Date 
  of 2023-12-12, Order Date will be today's date, Delivery Status will be CREATED and Address will be the Customer's 
  Address. \
  **Before:**
![Screenshot 2023-10-31 at 3.31.43 PM.png](..%2F..%2FScreenshot%202023-10-31%20at%203.31.43%20PM.png)
  **After:**
![Screenshot 2023-10-31 at 3.48.30 PM.png](..%2F..%2FScreenshot%202023-10-31%20at%203.48.30%20PM.png)

[&uarr; Back to Table of Contents](#top)


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

>Updates the delivery details of an existing delivery in the delivery book.

Oh no! Did you key in the wrong details for a delivery? Or did your customer change some details to his 
delivery? No worries! Just edit the details of a delivery simply by using this feature.

**Format:** `delivery edit DELIVERY_ID [--name DELIVERY_NAME] [--customer CUSTOMER_ID] [--date DELIVERY_DATE]
[--status STATUS] [--note NOTE]`

**Examples:**
- `delivery edit 1 --status CANCELLED --note Sudden overseas business trip to attend to.` </br>
  Edits Delivery 1's Delivery Status to CANCELLED and edits the delivery's note. (If delivery previously did not 
  have a note, a note will be created to the delivery) 
- `delivery edit 2 --name Vanilla Cake --customer 3` </br>
Edits Delivery 2's name to Vanilla Cake as it was misspelled and edits the customer to Customer 3 as User 
  accidentally typed in 2 instead. \
  **Before:**
![Screenshot 2023-10-31 at 4.07.02 PM.png](..%2F..%2FScreenshot%202023-10-31%20at%204.07.02%20PM.png)
  **After:**
[Haven't merged yet] \
[&uarr; Back to Table of Contents](#top)


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

### Delete delivery

>Deletes the specified delivery.

Feel like your delivery book is getting cluttered up? Maybe you just want to get rid of a few deliveries that have 
been cancelled or completed. If that's the case, simply use this feature to delete the delivery.

**Format:** `delivery delete DELIVERY_ID`

<div style="padding: 15px; border: 1px solid transparent; border-color: transparent; margin-bottom: 20px; border-radius: 4px; color: #a94442; background-color: #f2dede; border-color: #ebccd1;">
[!Warning] Be careful! This action is irreversible. Once deleted, the delivery cannot be recovered.
</div>

**Example:**
- `delivery delete 1` </br>
Deletes delivery 1 from the delivery book.
  **Before:**
![Screenshot 2023-10-31 at 4.06.05 PM.png](..%2F..%2FScreenshot%202023-10-31%20at%204.06.05%20PM.png)
  **After:** 
![Screenshot 2023-10-31 at 4.07.02 PM.png](..%2F..%2FScreenshot%202023-10-31%20at%204.07.02%20PM.png)
[&uarr; Back to Table of Contents](#top)


