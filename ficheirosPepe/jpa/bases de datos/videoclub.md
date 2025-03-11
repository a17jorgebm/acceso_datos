classDiagram
direction BT
class actor {
   varchar(45) first_name
   varchar(45) last_name
   timestamp last_update
   integer actor_id
}
class address {
   varchar(50) address
   varchar(50) address2
   varchar(20) district
   smallint city_id
   varchar(10) postal_code
   varchar(20) phone
   timestamp last_update
   integer address_id
}
class category {
   varchar(25) name
   timestamp last_update
   integer category_id
}
class city {
   varchar(50) city
   smallint country_id
   timestamp last_update
   integer city_id
}
class country {
   varchar(50) country
   timestamp last_update
   integer country_id
}
class customer {
   smallint store_id
   varchar(45) first_name
   varchar(45) last_name
   varchar(50) email
   smallint address_id
   boolean activebool
   date create_date
   timestamp last_update
   integer active
   integer customer_id
}
class film {
   varchar(255) title
   text description
   year release_year
   smallint language_id
   smallint rental_duration
   numeric(4,2) rental_rate
   smallint length
   numeric(5,2) replacement_cost
   mpaa_rating rating
   timestamp last_update
   text[] special_features
   tsvector fulltext
   integer film_id
}
class film_actor {
   timestamp last_update
   smallint actor_id
   smallint film_id
}
class film_category {
   timestamp last_update
   smallint film_id
   smallint category_id
}
class inventory {
   smallint film_id
   smallint store_id
   timestamp last_update
   integer inventory_id
}
class language {
   char(20) name
   timestamp last_update
   integer language_id
}
class payment {
   smallint customer_id
   smallint staff_id
   integer rental_id
   numeric(5,2) amount
   timestamp payment_date
   integer payment_id
}
class rental {
   timestamp rental_date
   integer inventory_id
   smallint customer_id
   timestamp return_date
   smallint staff_id
   timestamp last_update
   integer rental_id
}
class staff {
   varchar(45) first_name
   varchar(45) last_name
   smallint address_id
   varchar(50) email
   smallint store_id
   boolean active
   varchar(16) username
   varchar(40) password
   timestamp last_update
   bytea picture
   integer staff_id
}
class store {
   smallint manager_staff_id
   smallint address_id
   timestamp last_update
   integer store_id
}

address  -->  city : city_id
city  -->  country : country_id
customer  -->  address : address_id
film  -->  language : language_id
film_actor  -->  actor : actor_id
film_actor  -->  film : film_id
film_category  -->  category : category_id
film_category  -->  film : film_id
inventory  -->  film : film_id
payment  -->  customer : customer_id
payment  -->  rental : rental_id
payment  -->  staff : staff_id
rental  -->  customer : customer_id
rental  -->  inventory : inventory_id
rental  -->  staff : staff_id
staff  -->  address : address_id
store  -->  address : address_id
store  -->  staff : manager_staff_id:staff_id
