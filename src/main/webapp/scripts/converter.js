let nav_links = document.querySelectorAll(".nav-link");
let views = document.querySelectorAll(".converter-panel");
let fromUnit;
let toUnit;
let inputAmount;
let outputAmount;
let converterType;

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
    switch (destinationID) {
      case "#weight-converter":
        converterType = "weight";
        break;
      case "#length-converter":
        converterType = "length";
        break;
      case "#energy-converter":
        converterType = "energy";
        break;
      default:
        converterType = "weight";
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
      calculateFromInput(
        converterType,
        inputAmount,
        fromUnit,
        toUnit,
        outputAmount
      );
    });
    document.querySelector(
      `${destinationID} .input-field .input-group-text`
    ).innerText = fromUnit.children[fromUnit.selectedIndex].value;
    document.querySelector(
      `${destinationID} .output-field .input-group-text`
    ).innerText = toUnit.children[toUnit.selectedIndex].value;
    fromUnit.onchange = function () {
      // console.log(document.querySelector(`${destinationID} .input-field .input-group-text`))
      document.querySelector(
        `${destinationID} .input-field .input-group-text`
      ).innerText = this.children[this.selectedIndex].value;
      calculateFromInput(
        converterType,
        inputAmount,
        fromUnit,
        toUnit,
        outputAmount
      );
    };
    toUnit.onchange = function () {
      document.querySelector(
        `${destinationID} .output-field .input-group-text`
      ).innerText = this.children[this.selectedIndex].value;
      calculateFromInput(
        converterType,
        inputAmount,
        fromUnit,
        toUnit,
        outputAmount
      );
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

  switch (converterType) {
    case "weight":
      outputElement.value = WeightConverter.convert(
        fromU,
        toU,
        inputElement.value
      ).toFixed(6);
      break;
    case "length":
      outputElement.value = LengthConverter.convert(
        fromU,
        toU,
        inputElement.value
      ).toFixed(6);
      break;
    case "energy":
      let output = EnergyConverter.convert(
        fromU,
        toU,
        inputElement.value
      )
      outputElement.value = Number(output).toFixed(6)
      break;
    default:
      outputElement.value = WeightConverter.convert(
        fromU,
        toU,
        inputElement.value
      ).toFixed(6);
  }
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

class LengthConverter {
  static m_to_cm = 100;
  static m_to_dm = 10;
  static m_to_mm = 1000;
  static cm_to_mm = 10;
  static m_to_km = 1 / 1000;
  static ft_to_m = 0.3048;
  static ft_to_in = 12;
  static ft_to_mi = 1 / 5280;
  static ft_to_nmi = 1 / 6076.1;

  static toMeter(fromUnit, amount) {
    switch (fromUnit) {
      case "mm":
        return amount / this.m_to_mm;
      case "cm":
        return amount / this.m_to_cm;
      case "dm":
        return amount / this.m_to_dm;
      case "m":
        return amount;
      case "km":
        return amount / this.m_to_km;
      case "in":
      case "ft":
      case "mi":
      case "nmi":
        return this.toFeet(fromUnit, amount) * this.ft_to_m;
    }
  }
  static toFeet(fromUnit, amount) {
    switch (fromUnit) {
      case "mm":
      case "cm":
      case "dm":
      case "m":
      case "km":
        return this.toMeter(fromUnit, amount) / this.ft_to_m;
      case "in":
        return amount / this.ft_to_in;
      case "ft":
        return amount;
      case "mi":
        return amount / this.ft_to_mi;
      case "nmi":
        return amount / this.ft_to_nmi;
    }
  }
  static convert(fromUnit, toUnit, amount) {
    let amountM = this.toMeter(fromUnit, amount);
    let amountFt = this.toFeet(fromUnit, amount);
    // console.log(amountM)
    // console.log(amountFt)
    switch (toUnit) {
      case "mm":
        return amountM * this.m_to_mm;
      case "cm":
        return amountM * this.m_to_cm;
      case "dm":
        return amountM * this.m_to_dm;
      case "m":
        return amountM;
      case "km":
        return amountM * this.m_to_km;
      case "in":
        return amountFt * this.ft_to_in;
      case "ft":
        return amountFt;
      case "mi":
        return amountFt * this.ft_to_mi;
      case "nmi":
        return amountFt * this.ft_to_nmi;
    }
  }
}

class EnergyConverter {
  static cal_to_kcal = 1 / 1000;
  static cal_to_j = 4.184;
  static j_to_cal = 0.239;
  static j_to_kj = 1 / 1000;

  static toKcal(fromUnit, amount) {
    switch (fromUnit) {
      case "J":
      case "kJ":
        return this.tokJ(fromUnit,amount) / this.cal_to_j
      case "cal":
        return amount * this.cal_to_kcal;
      case "kcal":
        return amount;
      default:
        return -1;
    }
  }
  static tokJ(fromUnit, amount) {
    switch (fromUnit) {
      case "J":
        return amount * this.j_to_kj
      case "kJ":
        return amount
      case "cal":
      case "kcal":
        return this.toKcal(fromUnit,amount) * this.cal_to_j
    }
  }
  static convert(fromUnit, toUnit, amount) {
    let kcal = this.toKcal(fromUnit, amount);
    let kJ = this.tokJ(fromUnit,amount)
    // console.log(kcal)
    // console.log(kJ)
    switch (toUnit) {
      case "J":
        return kJ * 1000;
      case "kJ":
        return kJ
      case "cal":
        return kcal * 1000
      case "kcal":
        return kcal
    }
  }
}
console.log(WeightConverter.convert("mg", "kg", 1000000));

function copiedTooltip(tooltip) {
  var copyText = outputAmount;
  copyText.select();
  copyText.setSelectionRange(0, 99999);
  navigator.clipboard.writeText(copyText.value);
  tooltip.innerHTML = "Copied: " + copyText.value;
}

function resetTooltip(tooltip) {
  tooltip.innerHTML = "Copy to clipboard";
}
