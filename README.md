# DELI-cious Order Handler CLI
## Overview
  A basic order creator for a fictional sandwich company. Asks for sandwich specifications, confirms those specifications, and creates a receipt file.
## Features
  **- Make orders -**
        Creates order outlining the desired sandwich toppings.
  **- Print receipts -**
        Automatically creates a receipt when an order is confirmed.
  **- Price Calculation -**
        Automatically calculates the price of an order.

![image](https://github.com/user-attachments/assets/f76bb0a6-ffcf-4918-919c-4d95defd796b)

**- Code! -**

```
public ArrayList<Sandwich.PremiumMeats> fixMeats(ArrayList<Sandwich.PremiumMeats> meats, ArrayList<Sandwich.PremiumMeats> extraMeats) {
        for (int i = 0; i < extraMeats.size(); i++){
            int y = 0;
            for (Sandwich.PremiumMeats meat: meats){
                if (extraMeats.get(i) == meat){
                    y++;
                }
            }
            if (y == 0){
                extraMeats.remove(i);
            }

        }
    return extraMeats;
    }
```

**- Structure -**

![SandwichStructure drawio](https://github.com/user-attachments/assets/31fe5205-9c8a-44b9-87f8-06a0403e3fde)



## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/BryanG2442/DELI-cious-Order-Creator.git
   cd DELI-cious-Order-Creator        
