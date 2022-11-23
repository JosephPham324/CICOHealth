let nav_links = document.querySelectorAll(".nav-link");
let views = document.querySelectorAll(".converter-panel");
let fromUnit;
let toUnit;
let inputAmount;
let outputAmount;
let converterType

function off_links() {
  nav_links.forEach((link) => {
    link.parentElement.classList.remove("active");
  });
}
function off_views() {
  views.forEach((view) => {
    // console.log(view)
    view.classList.remove("active");
  });
}
nav_links.forEach((link) => {
  link.addEventListener("click", () => {
    off_links();
    link.parentElement.classList.add("active");
    let destinationID = link.getAttribute("data-destination");
    let destination = document.querySelector(destinationID);
    off_views();
    switch (destinationID){
      case "#weight-converter":
        converterType = "weight";
        break;
      case "#length-converter":
        converterType = "length";
        break;
      case "#energy-converter":
        converterType="energy";
        break;
      default:
        converterType = "weight"
    }
    destination.classList.add("active");
    fromUnit = document.querySelector(
      `${destinationID} select[name='to-convert']`
    );
    toUnit = document.querySelector(
      `${destinationID} select[name='converted']`
    );
    inputAmount = document.querySelector(
      `${destinationID} input[name='input']`
    );
    outputAmount = document.querySelector(
      `${destinationID} input[name='result']`
    );
    inputAmount.addEventListener("input", () => {
      calculateFromInput(converterType,inputAmount, fromUnit, toUnit, outputAmount);
    });
    fromUnit.onchange = function () {
      // console.log(document.querySelector(`${destinationID} .input-field .input-group-text`))
      document.querySelector(
        `${destinationID} .input-field .input-group-text`
      ).innerText = this.children[this.selectedIndex].value;
      calculateFromInput(converterType,inputAmount, fromUnit, toUnit, outputAmount);
    };
    toUnit.onchange = function () {
      document.querySelector(
        `${destinationID} .output-field .input-group-text`
      ).innerText = this.children[this.selectedIndex].value;
      calculateFromInput(converterType,inputAmount, fromUnit, toUnit, outputAmount);
    };
  });
});
function calculateFromInput(
  converterType,
  inputElement,
  fromUnitElement,
  toUnitElement,
  outputElement
) {
  let fromU = fromUnitElement.children[fromUnitElement.selectedIndex].value;
  let toU = toUnitElement.children[toUnitElement.selectedIndex].value;
//   console.log(fromU);
//   console.log(toU);
  outputElement.value = WeightConverter.convert(
    fromU,
    toU,
    inputElement.value
  ).toFixed(6);
}
nav_links[0].click();

class WeightConverter {
  static kg_to_g = 1000;
  static g_to_mg = 1000;
  static kg_to_lbs = 2.20462;
  static lbs_to_oz = 16;
  static lbs_to_st = 1 / 14;
  static lbs_to_qtr = 1 / 28;
  static lbs_to_cwt = 1 / 112;

  static toKg(fromUnit, amount) {
    switch (fromUnit) {
      case "mg":
        return amount / this.g_to_mg / this.kg_to_g;
      case "g":
        return amount / this.kg_to_g;
      case "kg":
        return amount;
      case "lbs":
        return amount / this.kg_to_lbs;
      case "oz":
      case "st":
      case "qtr":
      case "cwt":
        return this.toKg("lbs", this.toLbs(fromUnit, amount));
      default:
        return -1;
    }
  }

  static toLbs(fromUnit, amount) {
    switch (fromUnit) {
      case "mg":
      case "g":
        return this.toLbs("kg", this.toKg(fromUnit, amount));
      case "kg":
        return amount * this.kg_to_lbs;
      case "oz":
        return amount / this.lbs_to_oz;
      case "lbs":
        return amount;
      case "st":
        return amount / this.lbs_to_st;
      case "qtr":
        return amount / this.lbs_to_qtr;
      case "cwt":
        return amount / this.lbs_to_cwt;
      default:
        return -1;
    }
  }

  static convert(fromUnit, toUnit, amount) {
    let amountKg = this.toKg(fromUnit, amount);
    let amountLbs = this.toLbs(fromUnit, amount);
    switch (toUnit) {
      case "mg":
        return amountKg * this.kg_to_g * this.g_to_mg;
      case "g":
        return amountKg * this.kg_to_g;
      case "kg":
        return amountKg;
      case "lbs":
        return amountKg * this.kg_to_lbs;
      case "oz":
        return amountLbs * this.lbs_to_oz;
      case "st":
        return amountLbs * this.lbs_to_st;
      case "qtr":
        return amountLbs * this.lbs_to_qtr;
      case "cwt":
        return amountLbs * this.lbs_to_cwt;
    }
  }
}
console.log(WeightConverter.convert("mg", "kg", 1000000));

function copiedTooltip(tooltip) {
  // console.log(tooltip.children)
  var copyText = outputAmount
  // console.log(outputAmount)
  copyText.select();
  copyText.setSelectionRange(0, 99999);
  navigator.clipboard.writeText(copyText.value);
  
  // var tooltip = document.getElementById("myTooltip");
  tooltip.innerHTML = "Copied: " + copyText.value;
}

function resetTooltip(tooltip) {
  // console.log(tooltip.children)
  // var tooltip = document.getElementById("myTooltip");
  tooltip.innerHTML = "Copy to clipboard";
}