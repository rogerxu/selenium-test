require('chromedriver');
const {Builder} = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');

let driver = new Builder()
  .forBrowser('chrome')
  .build();

module.exports = driver;
