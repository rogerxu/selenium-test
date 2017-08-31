const phantomjs = require('phantomjs-prebuilt');
const {Builder, Capabilities} = require('selenium-webdriver');

let capabilities = Capabilities.phantomjs();
capabilities.set("phantomjs.binary.path", phantomjs.path);

let driver = new Builder()
  .withCapabilities(capabilities)
  .build();

module.exports = driver;
