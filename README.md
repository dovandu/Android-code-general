# Android-code-general

## 1. HideOnScrollExample

https://github.com/mzgreen/HideOnScrollExample

## 2: fix build errors (lint-gradle-api.jar)

```sh
mover jcenter() below google()
```
## 3: Guide Android networking:
https://github.com/codepath/android_guides/wiki/Networking-with-the-Fast-Android-Networking-Library

## 4: Multi slider:
https://github.com/Jay-Goo/RangeSeekBar

## 5: Top 15 seekbar, timline
https://uxplanet.org/top-15-seekbar-and-slider-github-ui-libraries-and-components-java-swift-kotlin-d0f6a9658be3


## 6: Custom spinner item (icon and text):
- https://abhiandroid.com/ui/custom-spinner-examples.html
- https://stackoverflow.com/questions/38796775/add-image-to-item-spinner

## 7: Loadmore RecycleView
- https://github.com/codepath/android_guides/wiki/Endless-Scrolling-with-AdapterViews-and-RecyclerView

## 8: get hash key by code:
- debug
```java
PackageInfo info;
try {
    info = getPackageManager().getPackageInfo("com.you.name", PackageManager.GET_SIGNATURES);
    for (Signature signature : info.signatures) {
        MessageDigest md;
        md = MessageDigest.getInstance("SHA");
        md.update(signature.toByteArray());
        String something = new String(Base64.encode(md.digest(), 0));
        //String something = new String(Base64.encodeBytes(md.digest()));
        Log.e("hash key", something);
    }
} catch (NameNotFoundException e1) {
    Log.e("name not found", e1.toString());
} catch (NoSuchAlgorithmException e) {
    Log.e("no such an algorithm", e.toString());
} catch (Exception e) {
    Log.e("exception", e.toString());
}
```
- release
``` I have also experience an issue like by using the above HashKey the login works fine if I install the release APK directly to the device, But when I upload the APK to Play Store and install app from store then it shows the same Login failed error. The fix for this is as follows:

1. Go to Release Management here
2. Select Release Management  -> App Signing
3. You can see SHA1 key in hex format App signing certificate. 
4. Copy the SHA1 in hex format and convert it in to base64 format, you can use this link do that without the SHA1: part of the hex. 
5. Go to Facebook developer console and add the key(after convert to base 64) in the settings —> basic –> key hashes.```
