[![Build Status](https://travis-ci.org/spdeepak/Stackoverflow.svg?branch=master)](https://travis-ci.org/spdeepak/Stackoverflow) [![Coverage Status](https://coveralls.io/repos/github/spdeepak/textmining/badge.svg?branch=master)](https://coveralls.io/github/spdeepak/textmining?branch=master)

# Stackoverflow Java API (Under Construction)

Stackoverflow Rest API - https://api.stackexchange.com/docs

# Usage
1. To get a particular number of Answers with in a specified date, order, and Sort order.
	Create a AnswerInitializer object and pass it to AnswerItemURLGenerator to get a JsonURL and pass the same to AnswerItem's Fetcher class and get the list of AnswerItem's
