# Monopoly 

## Project Overview
This is a **Java console-based (CLI) implementation** of the game Monopoly, developed for educational purposes. The game is designed to progressively evolve, incorporating more advanced features.

---

## Features
-The game includes the following features:

- **Players**
  - Up to **four players**, each with a **name** and a **unique symbol** assigned at the start of the game.
  
- **Bank**
  - The bank manages all **payments, fees, and transactions**.
  - Initial bank balance: **1,000,000 CHF**.
  - Each player starts with **2,000 CHF**.

- **Board**
  - The board is **11x11** and players move **clockwise** by rolling **two six-sided dice**.
  - Landing on a cell may trigger payments, bonuses, or other effects.

- **Cell Types**
  1. **Start Cell**: players receive a **100 CHF bonus** when passing or landing on it.
  2. **Parking Cell**: neutral cell, no action required.
  3. **Property Cell**:  
     - Has a **name** and **color group**.
     - Players pay a **fee** when landing on owned properties.
     - Players can **buy unowned properties**.
     - Owning all properties of a color allows **building houses (up to 4) and hotels (1 max per property)**.
  4. **Taxes Cell**:  
     - **Wealth Tax**: 10% of the player's total money.  
     - **Luxury Tax**: 200 CHF.
  5. **Prison Cell**:  
     - Players sent here must roll **two identical dice** within **3 turns** to get out.  
     - Failing this requires paying a **bailout fee**.
  6. **Go-To Prison Cell**: sends the player directly to prison.
  7. **Chance Cells** and **Unexpected Cells**: players draw a card with special effects.
 

- **End of Game**
  - The game ends when all but one player are bankrupt. The remaining player is declared the winner.

