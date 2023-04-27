async function getImageAspectRatio(url) {
  try {
    const img = new Image();
    img.src = url;
    await img.decode();
    const ratio = img.width / img.height;
    console.log(`The aspect ratio of ${url} is ${ratio.toFixed(2)}`);
  } catch (error) {
    console.error(error);
  }
}

const imageUrl = 'https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png';

getImageAspectRatio(imageUrl);
