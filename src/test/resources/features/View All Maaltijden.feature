Feature: View menu
  As a potential customer
  I want to be able to see all available meals
  So that I can order the meals I want to eat
# Personas
# Jan – Student TI
Rule: Toon alle maaltijden die op het menu staan
  Scenario: Alle maaltijden worden getoond
    Given dat er maaltijden op het menu staan
    When “Jan” op het menu kijkt
    Then worden alle maaltijden getoond die op het menu staan

  Scenario: Er worden geen maaltijden getoond want er staan geen maaltijden op het menu
    Given er geen maaltijden op het menu staan
    When “Jan” op het menu kijkt
    Then krijgt “Jan” een melding dat er momenteel nog geen broodjes op het menu staan


Rule: Informatie over allergieën en al dan niet vegetarisch moet getoond worden

  Scenario: Informatie over sporen wordt weergegeven
  Given Dat een “broodje brie” “walnoten” bevat
  When “Jan” op het menu kijkt
  Then ziet hij dat de maaltijd sporen van walnoten bevat

# TODO
#  Scenario: Informatie wanneer de maaltijd vegetarisch is wordt weergegeven
#  Gegeven lijst van maaltijden
#  Wanneer “Jan” het menu opent
#  Dan ziet hij dat de maaltijd vegetarisch is
#
#  Scenario: Informatie wanneer de maaltijd glutenvrij is wordt weergegeven
#  Gegeven lijst van maaltijden
#  Wanneer “Jan” het menu opent
#  Dan ziet hij dat de maaltijd glutenvrij is
#
#  Scenario Outline: Extra Informatie over de maaltijd wordt weergegeven
#  Gegeven lijst van maaltijden
#  Wanneer “Jan” het maaltijd “<maaltijd>” selecteert
#  Dan ziet hij dat de maaltijd “<info>” is
#    Examples:
#      | maaltijd             | info              |
#      | broodje brie            | sporen van walnoten |
#      | broodje veggylicious        | vegetarisch         |
#      | broodje spelt            | glutenvrij          |
#
#  Scenario: Extra Informatie over de maaltijden wordt weergegeven
#    Given dat er maaltijden zijn met extra informatie
#      | Maaltijd                                 | Allergieën                              | Vegetarisch?    |
#      | Broodje brie met walnoten   | Sporen van noten, Gluten  |                          |
#      | Broodje Veggylicious         | Gluten                                | Vegetarisch      |
#      | Frikandel                            |                                               |                          |
#    When "Jan" het menu bekijkt
#    Then zou "Jan" de maaltijden te zien moeten krijgen met de extra informatie
#