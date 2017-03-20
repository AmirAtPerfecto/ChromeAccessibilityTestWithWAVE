# ChromeAccessibilityTestWithWAVE
Demo of accessibility test on Chrome with WAVE Toolbar

This project uses the WAVE toolbar (webaim.org), which comes preinstalled on Perfecto's Chrome browsers.
Essentially, you launch the browser (add this to the capabilities, see utils.java:)

// Invoke the WAVE toolbar on browser launch
    		ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=C:\\Users\\perfecto\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\jbbplnpkjmmeebjpijfedlgcdilocofh\\1.0.1_0");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

Launch the site you want to test (WAVEToolbarExamplePackageTestClass.java).
And then you can invoke the WAVE toolbar by clicking on the icon, that's done in WAVEAccessibilityHelper.
This is also where we dismiss the developer add-on warning popup.

Last, we go over all the errors found by the WAVE toolbar analysis and print those out, including the ID of the HTML element.
