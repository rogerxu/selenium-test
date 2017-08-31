const {Builder, By, promise, until} = require('selenium-webdriver');
// const test = require('selenium-webdriver/testing');

promise.USE_PROMISE_MANAGER = false;

describe('Baidu Search', function() {
  let driver;

  beforeEach(async function() {
    driver = await require('../lib/webdriver/chrome');
  });

  afterEach(async function() {
    await driver.quit();
  });

  it('example', async function() {
    await driver.get('https://www.baidu.com');

    let searchbox = await driver.findElement(By.name('wd'));
    await searchbox.sendKeys('webdriver');
    await searchbox.submit();

    await driver.wait(until.titleContains('webdriver'), 1000);
  });
});
