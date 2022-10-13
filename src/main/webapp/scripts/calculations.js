let protein = 4
let fat = 9
let carb = 4
const male = false
const female = true
const activenessMap = [1.2,1.375,1.55,1.725]


function calculateBMR(weight,height,age,gender){
    let BMR=0;
    if (gender == male){
        BMR = 13.397*weight + 4.799*height - 5.677*age + 88.362;
    } else {
        BMR = 9.247* weight + 3.098*height - 4.330*age + 447.593;
    }
    console.log(BMR)
    return BMR;
}

function calculateTDEE(weight,height,age,gender,activeness){
    return calculateBMR(weight,height,age,gender) * activenessMap[activeness];
}


function createCaloriePlans(weight,height,age,gender,activeness){
    class CaloriePlan{
        constructor(name, maintenanceCal,planCal,energyBalancePerWeek){
            this.name=name
            this.maintenanceCal = maintenanceCal
            this.planCal = planCal
            this.energyBalancePerWeek = energyBalancePerWeek
        }
    }
    let TDEE = calculateTDEE(weight,height,age,gender,activeness)
    let plans = []
    plans.push(new CaloriePlan('maintenance',TDEE,TDEE,0))
    plans.push(new CaloriePlan('Light Weight Loss',TDEE,TDEE-300,-300*7))
    plans.push(new CaloriePlan('Moderate Weight Loss',TDEE,TDEE-500,-500*7))
    plans.push(new CaloriePlan('Extreme Weight Loss',TDEE,TDEE-700,-700*7))
    plans.push(new CaloriePlan('Light Weight Gain',TDEE,TDEE+300,300*7))
    plans.push(new CaloriePlan('Moderate Weight Gain',TDEE,TDEE+500,500*7))
    plans.push(new CaloriePlan('Extreme Weight Gain',TDEE,TDEE+700,700*7))

    return plans
}

class MacroPlan{
    constructor(totalCal, proteinPercentage, fatPercentage, carbPercentage,proteinCalories,fatCalories,carbCalories,proteinWeight,fatWeight,carbWeight){
        this.totalCal = totalCal
        this.proteinPercentage = proteinPercentage
        this.fatPercentage = fatPercentage
        this.carbPercentage = carbPercentage
        this.proteinCalories = proteinCalories
        this.fatCalories = fatCalories
        this.carbCalories = carbCalories
        this.proteinWeight = proteinWeight
        this.fatWeight = fatWeight
        this.carbWeight = carbWeight
    }

    get(attribute){
        return this[attribute]
    }
    set(attribute,value){
        this.attribute = value
    }
}


function calculateMacro(totalCal, proteinPercentage, fatPercentage, carbPercentage){
    let onePercent = totalCal / 100
    let proteinCalories = proteinPercentage * onePercent
    let fatCalories = fatPercentage * onePercent
    let carbCalories = carbPercentage * onePercent
    let proteinWeight = proteinPercentage / protein
    let fatWeight = fatCalories / fat
    let carbWeight = carbCalories / carb

    return new MacroPlan(totalCal, proteinPercentage, fatPercentage, carbPercentage,proteinCalories,fatCalories,carbCalories,proteinWeight,fatWeight,carbWeight)
}

class FoodItem{
    constructor(name,totalWeight,totalCal, proteinWeight,fatWeight,carbWeight){
        this.name = name
        this.totalWeight = totalWeight
        this.totalCal = totalCal
        this.proteinWeight = proteinWeight
        this.fatWeight = fatWeight
        this.carbWeight = carbWeight
    }
    get(attribute){
        return this[attribute]
    }
    set(attribute,value){
        this.attribute = value
    }
}
class Meal{
    constructor(mealName,totalCal, proteinWeight,fatWeight,carbWeight, foodItems){
        this.mealName=mealName
        this.totalCal = totalCal
        this.proteinWeight = proteinWeight
        this.fatWeight = fatWeight
        this.carbWeight = carbWeight
        this.foodItems = foodItems
    }
    get(attribute){
        return this[attribute]
    }
    set(attribute,value){
        this.attribute = value
    }
    addFoodItem(item){
        this.foodItems.push(item)
    }
}

function createMeal(mealName,foodItems){
    let totalCal=0;
    let proteinWeight=0;
    let fatWeight=0;
    let carbWeight=0;
    foodItems.forEach(item=>{
        
        if (item instanceof FoodItem){
            console.log(item)
            totalCal+=item.get('totalCal')
            proteinWeight+=item.get('proteinWeight')
            fatWeight+=item.get('fatWeight')
            carbWeight+=item.get('carbWeight')
        }
    })
    return new Meal(mealName,totalCal,proteinWeight,fatWeight,carbWeight,foodItems)
}

