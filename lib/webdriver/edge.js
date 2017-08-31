require('edgedriver');
const edge = require('selenium-webdriver/edge');

let service = new edge.ServiceBuilder()
  .setPort(55555)
  .build();

let options = new edge.Options();
// configure browser options ...

let driver = edge.Driver.createSession(options, service);

module.exports = driver;
