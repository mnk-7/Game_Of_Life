# Game_Of_Life

Project contains implementation of Convay's Game of Life. It's played on two-dimensional grid of squares where each cell can be alive or dead. Depending on the state of the neighbouring cells, the cell is changing its state: 
- overpopulation: any live cell dies if it is surrounded by more than four live neighbours
- underpopulation: any live cell dies if it is surrounded by fewer than two live neighbours
- resurrection: any dead cell comes to life if it has exactly three live neighbours
- otherwise: state of the cell doesn't change
