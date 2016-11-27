# Zleek
How to get data from the image:
[list]
* 1. **Clear background**
Using openCV grab-cut
* 2. **Matlab Calculations** for extracting segments and classify different garments that a person is wearing.
We use conditional Random Fields (CRF) to recognize patterns in an image. With the segmented area’s we can classify different types of garments for example shirts, pants, belt, shoes etc. This is done with a library called Clothes Parsing. For full technical reference see.
* 3. Using the coordinates of the segments we **identify patterns and colors in each garment**.


What do we need?
Source
Garment item:
dominant colors
pattern

Image
Occasion
User input
Age group
Account (Facebook / Google / etc)
Body shape
Image / input
Height
Image / input


For suggestions, we will use Zalando API to propose related products to the person.
