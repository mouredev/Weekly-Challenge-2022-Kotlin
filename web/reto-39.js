const original = document.querySelector('#originalArr');
const order = document.querySelector('#orderArr');

const generateNumbers = total => new Array(total).fill(0).map((_, index) => ({ type: `D-${index}`, value: Math.round(Math.random() * total * 2) }));

const generateChart = (id, data) => {
  return new Chart(id, {
    type: 'bar',
    data: {
      labels: data.map((item) => item.type),
      datasets: [{
        data: data.map(item => item.value)
      }]
    },
    options: {
      animation: false,
      plugins: {
        legend: {
          display: false
        }
      }
    }
  });
}

const quickSort = async data => {
  const payload = [...data]
  for (const [index, item] of payload.entries()) {
    if (item.value > payload[index + 1]?.value) {
        await delay(payload, index);
        generateChart('draw-quick-sort', payload);
        order.innerHTML = payload.map(item => item.value);
        return quickSort(payload);
    }
  }
}

const delay = (payload, index) => {
  return new Promise((res) => {
    setTimeout(() => {
      const [move] = payload.splice(index + 1, 1)
      payload.splice(index, 0, move);
      res(payload);
    }, 2);
  });
}

const numbers = generateNumbers(50);
original.innerHTML = numbers.map(item => item.value);
const chart = generateChart('draw-quick-sort', numbers);
quickSort(numbers);