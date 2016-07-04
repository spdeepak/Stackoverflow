[![Build Status](https://travis-ci.org/spdeepak/Stackoverflow.svg?branch=master)](https://travis-ci.org/spdeepak/Stackoverflow)

# Stackoverflow Java API (Under Construction)

Stackoverflow Rest API - https://api.stackexchange.com/docs

# Usage
1. To get a particular number of Answers with in a specified date, order, and Sort order.
	Create a AnswerInitializer object and pass it to AnswerItemURLGenerator to get a JsonURL and pass the same to AnswerItem's Fetcher class and get the list of AnswerItem's