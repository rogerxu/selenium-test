require('geckodriver');
const {Builder} = require('selenium-webdriver');
const firefox = require('selenium-webdriver/firefox');

let profile = new firefox.Profile();
profile.setPreference('marionette', true);
profile.setPreference('marionette.logging', 'TRACE');
let options = new firefox.Options().setProfile(profile);

let driver = new Builder()
  .forBrowser('firefox')
  .setFirefoxOptions(options)
  .build();

module.exports = driver;
