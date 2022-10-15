let protein = 4;
let fat = 9;
let carb = 4;
const male = false;
const female = true;
const activenessMap = [1.2, 1.375, 1.55, 1.725];

function calculateCalFromMacro(proteinWeight,fatWeight,carbWeight){
  return protein*proteinWeight + fatWeight*fat + carbWeight*carb
}

/**
 * Calculate Basal Metabolic Rate from health info
 * @param {Number} weight Person's weight
 * @param {Number} height Person's height
 * @param {Number} age Person's age
 * @param {Boolean} gender Person's gender
 * @returns calculated BMR
 */
function calculateBMR(weight, height, age, gender) {
  let BMR = 0;
  if (gender === male) {
    BMR = 13.397 * weight + 4.799 * height - 5.677 * age + 88.362;
  } else {
    BMR = 9.247 * weight + 3.098 * height - 4.33 * age + 447.593;
  }
  console.log(BMR);
  return BMR;
}

/**
 * Calculate Total Daily Energy Expenditure from health info
 * @param {Number} weight Person's weight
 * @param {Number} height Person's height
 * @param {Number} age Person's age
 * @param {Boolean} gender Person's gender
 * @param {Number} activeness Person's activenness
 * @returns calculated TDEE
 */
function calculateTDEE(weight, height, age, gender, activeness) {
  return calculateBMR(weight, height, age, gender) * activenessMap[activeness];
}
/**
 * Create calorie plans from health info
 * @param {Number} weight Person's weight
 * @param {Number} height Person's height
 * @param {Number} age Person's age
 * @param {Boolean} gender Person's gender
 * @param {Number} activeness Person's activenness
 * @returns 7 calorie plan for weight maintenance, weight loss and weight gain
 */
function createCaloriePlans(weight, height, age, gender, activeness) {
  class CaloriePlan {
    constructor(name, maintenanceCal, planCal, energyBalancePerWeek) {
      this.name = name;
      this.maintenanceCal = maintenanceCal;
      this.planCal = planCal;
      this.energyBalancePerWeek = energyBalancePerWeek;
    }
  }
  let TDEE = calculateTDEE(weight, height, age, gender, activeness);
  let plans = [];

  plans.push(new CaloriePlan("Maintenance", TDEE, TDEE, 0));
  plans.push(new CaloriePlan("Light Weight Loss", TDEE, TDEE - 300, -300 * 7));
  plans.push(new CaloriePlan("Moderate Weight Loss", TDEE, TDEE - 500, -500 * 7));
  plans.push(new CaloriePlan("Extreme Weight Loss", TDEE, TDEE - 700, -700 * 7));
  plans.push(new CaloriePlan("Light Weight Gain", TDEE, TDEE + 300, 300 * 7));
  plans.push(new CaloriePlan("Moderate Weight Gain", TDEE, TDEE + 500, 500 * 7));
  plans.push(new CaloriePlan("Extreme Weight Gain", TDEE, TDEE + 700, 700 * 7));

  return plans;
}

/**
 * Class for macro plan
 */
class MacroPlan {
  constructor(
    totalCal,
    proteinPercentage,
    fatPercentage,
    carbPercentage,
    proteinCalories,
    fatCalories,
    carbCalories,
    proteinWeight,
    fatWeight,
    carbWeight
  ) {
    this.totalCal = totalCal;
    this.proteinPercentage = proteinPercentage;
    this.fatPercentage = fatPercentage;
    this.carbPercentage = carbPercentage;
    this.proteinCalories = proteinCalories;
    this.fatCalories = fatCalories;
    this.carbCalories = carbCalories;
    this.proteinWeight = proteinWeight;
    this.fatWeight = fatWeight;
    this.carbWeight = carbWeight;
  }

  /**
   * Get an attribute in MacroPlan instance
   * @param {String} attribute Attribute name
   * @returns Attribute value in the object
   */
  get(attribute) {
    return this[attribute];
  }
  /**
   * Set value for an attribute in MacroPlan instance
   * @param {String} attribute Attribute name
   * @param {Data type of that attribute} value Value for the attribute
   */
  set(attribute, value) {
    this.attribute = value;
  }
}

/**
 * Calculate macro plan from calories and macro percentage
 * @param {Number} totalCal Total calories
 * @param {Number} proteinPercentage Protein percentage of the calories
 * @param {Number} fatPercentage Fat percentage of the calories
 * @param {Number} carbPercentage Carb percentage of the calories
 * @returns A macro plan
 */
function calculateMacro(
  totalCal,
  proteinPercentage,
  fatPercentage,
  carbPercentage
) {
  let onePercent = totalCal / 100;
  let proteinCalories = proteinPercentage * onePercent;
  let fatCalories = fatPercentage * onePercent;
  let carbCalories = carbPercentage * onePercent;
  let proteinWeight = proteinPercentage / protein;
  let fatWeight = fatCalories / fat;
  let carbWeight = carbCalories / carb;

  return new MacroPlan(
    totalCal,
    proteinPercentage,
    fatPercentage,
    carbPercentage,
    proteinCalories,
    fatCalories,
    carbCalories,
    proteinWeight,
    fatWeight,
    carbWeight
  );
}

/**
 * Class for food item object
 */
class FoodItem {
  constructor(
    name,
    totalWeight,
    totalCal,
    proteinWeight,
    fatWeight,
    carbWeight
  ) {
    this.name = name;
    this.totalWeight = totalWeight;
    this.totalCal = totalCal;
    this.proteinWeight = proteinWeight;
    this.fatWeight = fatWeight;
    this.carbWeight = carbWeight;
    this.originalWeight = totalWeight
    this.originalCal = totalCal;
    this.originalProteinWeight = proteinWeight;
    this.originalFatWeight = fatWeight;
    this.originalCarbWeight = carbWeight;
  }
  /**
   * Get an attribute in FoodItem instance
   * @param {String} attribute Attribute name
   * @returns Attribute value in the object
   */
  get(attribute) {
    return this[attribute];
  }
  /**
   * Set value for an attribute in FoodItem instance
   * @param {String} attribute Attribute name
   * @param {Data type of that attribute} value Value for the attribute
   */
  set(attribute, value) {
    this.attribute = value;
  }

  changeWeight(newWeight){
    this.totalWeight=newWeight
    let ratio = newWeight / this.originalWeight
    this.totalCal=this.originalCal *ratio
    this.proteinWeight=this.originalProteinWeight*ratio
    this.fatWeight=this.originalFatWeight*ratio
    this.carbWeight=this.originalCarbWeight*ratio
  }
}

/**
 * Class for Meal object
 */
class Meal {
  constructor(
    mealName,
    totalCal,
    proteinWeight,
    fatWeight,
    carbWeight,
    foodItems
  ) {
    this.mealName = mealName;
    this.totalCal = totalCal;
    this.proteinWeight = proteinWeight;
    this.fatWeight = fatWeight;
    this.carbWeight = carbWeight;
    this.foodItems = foodItems;
  }
  /**
   * Get an attribute in Meal instance
   * @param {String} attribute Attribute name
   * @returns Attribute value in the object
   */
  get(attribute) {
    return this[attribute];
  }
  /**
   * Set value for an attribute in Meal instance
   * @param {String} attribute Attribute name
   * @param {Data type of that attribute} value Value for the attribute
   */
  set(attribute, value) {
    this.attribute = value;
  }
  /**
   * Add a food item in the meal instance
   * @param {FoodItem} item FoodItem to add
   */
  addFoodItem(item) {
    this.totalCal += item.totalCal;
    this.proteinWeight += item.proteinWeight;
    this.fatWeight += item.fatWeight;
    this.carbWeight += item.carbWeight;
    this.foodItems.push(item);
  }
  findFoodItem(name){
    return this.foodItems.find(item=>item['name']==name)
  }
  removeFoodItem(name){
    let item = this.findFoodItem(name)
    this.totalCal -= item.totalCal;
    this.proteinWeight -= item.proteinWeight;
    this.fatWeight -= item.fatWeight;
    this.carbWeight -= item.carbWeight;
    this.foodItems.splice(this.foodItems.indexOf(item),1)
  }
  getNumberOfItems(){
    return this.foodItems.length;
  }
  // update(){
  //   this.foodItems.forEach((item)=>{
  //     this.totalCal+=item.get('totalCal')
  //     this.proteinWeight+=item.get('proteinWeight')
  //     this.fatWeight+=item.get('fatWeight')
  //     this.carbWeight+=item.get('carbWeight')
  //   })
  // }
}

/**
 * Create a meal from list of food items
 * @param {String} mealName Name of meal
 * @param {FoodItem collection} foodItems List of food items
 * @returns Meal object with attribute values calculated from foodItems
 */
function createMeal(mealName, foodItems) {
  let totalCal = 0;
  let proteinWeight = 0;
  let fatWeight = 0;
  let carbWeight = 0;
  foodItems.forEach((item) => {
    if (item instanceof FoodItem) {
      console.log(item);
      totalCal += item.get("totalCal");
      proteinWeight += item.get("proteinWeight");
      fatWeight += item.get("fatWeight");
      carbWeight += item.get("carbWeight");
    }
  });
  return new Meal(
    mealName,
    totalCal,
    proteinWeight,
    fatWeight,
    carbWeight,
    foodItems
  );
}