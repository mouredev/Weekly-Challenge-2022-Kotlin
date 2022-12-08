const handleDetector = require("./Challenge49");

const tests = {
  input: [
    "this is my Twitter handles @gerbosan and another handle is: @test0n3.",
    "this is my Twitter handles @gerbosan and my Mastodon handle too: @gerbosan@ruby.social.",
    "the tags I usually use are #ruby, #rails, #rubyonrails and #development.",
    "the webpages I visit frequently are www.linkedin.com, www.gmail.com, www.wikipedia.com",
    "here some addresses I like http://www.twitter.com, http://www.codeable.la, http://en.wikipedia.org, http://github.com",
    "some addresses are https://en.wikipedia.org, https://github.com",
    "a mix of handles to check @gerbosan, #ruby, @gerbosan@ruby.social, www.hotmail.com, #rails, https://gob.pe, wrong inputs @@gerbosan, ##handles, ww3.st.ec, 215.128.103.9",
    "",
    "here we add some text, but without handles.",
  ],
  output: [
    ["@gerbosan", "@test0n3"],
    ["@gerbosan", "@gerbosan@ruby.social"],
    ["#ruby", "#rails", "#rubyonrails", "#development"],
    ["www.linkedin.com", "www.gmail.com", "www.wikipedia.com"],
    [
      "http://www.twitter.com",
      "http://www.codeable.la",
      "http://en.wikipedia.org",
      "http://github.com",
    ],
    ["https://en.wikipedia.org", "https://github.com"],
    [
      "@gerbosan",
      "#ruby",
      "@gerbosan@ruby.social",
      "www.hotmail.com",
      "#rails",
      "https://gob.pe",
    ],
    [],
    [],
  ],
};

let errors = 0;
tests.input.forEach((test, index) => {
  const testFunction = handleDetector.func(test);
  const expected = tests.output[index];
  if (JSON.stringify(testFunction) != JSON.stringify(expected)) {
    errors += 1;
    console.log("\noriginal:", test);
    console.log(testFunction);
    console.log("expected:", expected);
  }
});

console.log(`Tests${errors != 0 ? " not " : " "}passed, ${errors} errors`);
