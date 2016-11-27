# Zleek
**How to get data from the image:**
* 1. ***Clear background***
Using openCV grab-cut
* 2. ***Matlab Calculations*** for extracting segments and classify different garments that a person is wearing.
We use conditional Random Fields (**CRF**) to recognize patterns in an image. With the segmented area’s we can classify different types of garments for example shirts, pants, belt, shoes etc. This is done with a library called Clothes Parsing. For full technical reference see.
[**More details can be found in the [article](http://hi.cs.waseda.ac.jp/~esimo/publications/SimoSerraACCV2014.pdf)**]
* 3. Using the coordinates of the segments we ***identify patterns and colors in each garment***.

![Table with iterations](http://clip2net.com/clip/m527982/0c5bd-clip-16kb.png)

For suggestions, we will use Zalando API to propose related products to the person.
