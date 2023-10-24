# User Guide for HomeBoss

This comprehensive user guide is your key to a seamless start with our cutting-edge software designed specifically for
home-based businesses. Our solution is tailored to enhance the efficiency of managing delivery addresses, simplifying
your operations. Within these pages, you'll find detailed coverage of the following essential topics:

- Getting Started
- Features
    - User
        - Register
        - Login
        - Update details [Coming Soon]
        - Logout
        - Account recovery
        - Account deletion
    - Customer
        - Add customer
        - Search for a customer [Coming Soon]
        - List customers
        - Sort the list of customers [Coming Soon]
        - Update customer details
        - Delete customer
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

# Getting Started

To get started, you will need to create an account and download the software. Once you have done that, you can follow
the instructions in the Getting Started Guide to start using the software.

# Features

\*[ ] specifies optional fields

## <span style="text-decoration:underline;">User</span>

### Register

**Format:** `register --user USERNAME --password PASSWORD --confirmPass CONFIRM_PASSWORD --secretQn SECRET_QUESTION --answer ANSWER`

**Example:** `register --user gabriel --password gabrielIsGreat --confirmPass gabrielIsGreat --secretQn First pet's name? --answer Koko`

**Accepted Values:**

_USERNAME:_ String

_PASSWORD:_ String

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

_USERNAME:_ String

_PASSWORD:_ String

**Command succeeds:** _Log in successful._

**Command fails (missing fields):** _Please fill up all the required fields._

**Command fails (wrong login credentials):** _Wrong username and/or password. Try again._

### Update details `[Coming Soon in v1.3]`

_Details coming soon..._

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

**Example:** `customer add --name Gabriel --phone 8765 4321 --email gabrielrocks@gmail.com --address RVRC Block B`

**Accepted Values:**

_NAME_: String

_PHONE_NUMBER_: 8 digit Integer

_EMAIL_: String with @ and . in valid email format

_ADDRESS_: String

**Command succeeds:** _Customer 1, Gabriel added._

**Command fails (missing field):** _Please fill up all the required fields (--name NAME --phone PHONE_NUMBER --email
EMAIL --address ADDRESS)._

### Search for a customer `[Coming Soon in v1.3]`

_Details coming soon..._

### List customers

Lists all the customers added in the address book.

**Format:** `customer list`

**Example:** `customer list`

**Accepted Values:**

_NIL_

**Command succeeds (>0 customers):**

_Here is the list of customers:_

1. _Benjamin, Phone: 9898 2323, Email: benjaminCSGod@gmail.com, Address: Carnegie Mellon University, South Block._
2. _Gambe, Phone: 9797 1313, Email: gambeRizzLord@gmail.com, Address: Kent Ridge Hall_
3. _Gabriel, Phone: 9090 9241, Email: gabrielSoCool@gmail.com, Address: RVRC Tower Block_

**Command succeeds (0 customer):** _There are no customers added yet!_

### Sort the list of customers `[Coming Soon in v1.3]`

_Details coming soon..._

### Update customer details

Updates the personal details of an existing customer in the address book.

**Format:** `customer edit CUSTOMER_ID [--name NAME] [--phone PHONE_NUMBER] [--email EMAIL] [--address ADDRESS]`

**Example:** `customer edit 1001 --name Gabriel -–phone 1234 5678 --email gabrielSoCool@gmail.com --address RVRC Block B Ben's Room`

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

### Create delivery

Creates a delivery.

**Format:** `delivery create DELIVERY_NAME --customer CUSTOMER_ID --date DATE`

**Example:** `delivery create furniture --customer 5 --date 2023-12-03`

**Accepted Values:**

_DELIVERY_NAME:_ String of 50 characters

_CUSTOMER_ID:_ Integer

_DATE:_ String in YYYY-MM-DD format

**Command succeeds:** _Delivery [1001] furniture created successfully for Customer 1, Gabriel!_

**Command fails (missing_fields):** _Please fill up all the required fields (DELIVERY_NAME --customer CUSTOMER_ID --date
DATE)!_

**Command fails (invalid_date):** _Invalid date provided!_

**Command fails (invalid_date_format):** _Please provide the date in the format: YYYY-MM-DD._

### Create a note for a delivery `[Coming Soon in v1.3]`

_Details coming soon..._

### View all deliveries

Shows a list of all deliveries.

**Format:** `delivery list [STATUS] [--sort SORT]`

**Example:** `delivery list pending --sort desc`

**Accepted Values:**

_STATUS_: String of either `pending` or `complete` or defaults to show all deliveries

_SORT_: String of either `asc` for ascending or `desc` for descending or defaults to sort by delivery date

**Command succeeds (>0 deliveries):**

1. _[1001] Gabriel’s Milk - Completed - Ordered 20th Sept 2023: Delivered on 30th Sept 2023_
2. _[1002] Gambe’s Meat - Completed - Ordered 22th Sept 2023: Delivered on 29th Sept 2023_
3. _[1003] Ben’s Coffee - Pending - Ordered 25th Sept 2023: Delivery on 1st October 2023_

**Command failed (0 deliveries):** _There are currently no deliveries!_

### View deliveries for the day `[Coming Soon in v1.3]`

_Details coming soon..._

### View details of deliveries

Shows the details of the specified delivery.

**Format:** `delivery view DELIVERY_ID`

**Example:** `delivery view 1001`

**Accepted Values:**

_DELIVERY_ID_: Integer

**Command succeeds:**

_[1001] Gabriel’s Milk_

_Customer ID: 1_<br />
_Customer: Gabriel_<br />
_Ordered on: 23rd September 2023_<br />
_Delivery Status: Pending_<br />
_Delivery on: 1st October 2023_

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

_Edited Delivery: [2] milk_
_COMPLETED_<br />
_Customer: Alex Yeoh_<br />
_Customer Id: 1_<br />
_Ordered On: 2023-10-21_<br />
_Delivered On: 2023-12-03_

**Command fails (invalid_status):** _Delivery Status should be one of CREATED, SHIPPED, COMPLETED, CANCELLED_

**Command fails (invalid_index):** _The delivery index provided is invalid_

**Command fails (missing_fields):**

_Invalid command format!_<br />
_delivery status: Edits the status of the delivery identified by the ID of the delivery. Existing status will be
overwritten by the input status._<br />
_Parameters: STATUS (must be one of CREATED/SHIPPED/COMPLETED/CANCELLED) ID (must be a integer representing a valid
ID)_<br />
_Example: delivery status COMPLETED 1_<br />

#### Change date of delivery

Changes the date of a specified delivery

**Format:** `delivery edit date DELIVERY_ID --date DATE`

**Example:** `delivery edit date 1001 --date 2023-12-12`

**Accepted Values:**

_DELIVERY_ID:_ Integer

_DATE:_ String of format YYYY-MM-DD

**Command succeeds:** _Delivery [1001] Gabriel’s Milk changed delivery date to 1st Oct 2023!_

**Command failed (one field missing):** _Please specify a delivery id and date!_

**Command failed (invalid date format):** _Please format date as YYYY-MM-DD._

**Command failed (delivery_id not in database):** _This delivery does not seem to exist!_

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

### Create a note for a delivery `[Coming Soon in v1.3]`

_Details coming soon..._
