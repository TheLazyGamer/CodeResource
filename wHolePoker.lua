nonOreBlocksTable = {"minecraft:gravel", "minecraft:dirt", "minecraft:stone", "minecraft:sand", "minecraft:flowing_water", "minecraft:lava"}
nonOreBlocksString = "minecraft:gravel_minecraft:dirt_minecraft:stone_minecraft:sand_minecraft:flowing_water_minecraft:lava_minecraft:grass"



-- Create the function for refueling
function checkFuel()
  while turtle.getFuelLevel() <= 200 do
    turtle.select(1)
    turtle.refuel(1)
    turtle.select(1)
  end --if
end --checkFuel()


-- Create the turnAround function
function turnAround()
  turtle.turnRight()
  turtle.turnRight()
end --turnAround()


-- Create the moveForward function
function moveForward(spaces)
	for spacesCnt=1,spaces do
		while turtle.detect() do
			turtle.dig()
			sleep(1)
		end
		while not turtle.forward() do
			turtle.dig()
			turtle.attack()
		end
	end
end --moveForward()


-- Create the digDown function
function digDown()
	while turtle.detectDown() do
		turtle.digDown()
	end
	while not turtle.down() do
		turtle.digDown()
		turtle.attackDown()
	end
end --digDown()


-- Create the canGoDown function
function canGoDown()
	local success, data = turtle.inspectDown()
	local blockName = data.name
	if blockName == "minecraft:bedrock" then
		return false
	else
		return true
	end
end --canGoDown()


-- Create the transferItems function
function transferItems()
	if turtle.detect() then
		if turtle.dig() then
			turtle.select(2)
			if turtle.place() then
				for itemIndex = 3, 16 do
					turtle.select(itemIndex)
					turtle.drop()
				end
				turtle.select(2)
				turtle.dig()
			end
		end
	end
	turtle.select(1)
end --transferItems()


-- Create the mineOres function
function mineOres()
	for sidesChecked = 1, 4 do
		turtle.turnLeft()
		local success, data = turtle.inspect()

		if success then
			local blockName = data.name
			local badBlockTest = string.find(nonOreBlocksString, blockName)
			if (badBlockTest) then
				--print("mine nothing")
			else
				turtle.dig()
			end
		end
	end

end --mineOres()


-- Create the riseUp function
function riseUp(depthCount)
	for rises=1,depthCount do
		while not turtle.up() do
			turtle.attackUp()
			turtle.digUp()
		end
	end
end --riseUp()

-- Create the goHome function
function goHome(backMovement, leftMovement)
	turnAround()
	--turtle is now facing backward
	moveForward(backMovement)
	
	--now make turtle face left toward the chest
	turtle.turnRight()
	moveForward(leftMovement)
	
	turtle.turnRight()
end --goHome()

print("Enter columns (at least 5)")
local squareColumns = tonumber(read())

print("Enter rows (at least 5)")
local squareRows = tonumber(read())

local startCounter = 1

for columnCnt=1,squareColumns do
	local forwardMovements = 0;
	checkFuel()
	if startCounter == 1 then
		moveForward(1)
		startCounter = startCounter + 1
		forwardMovements = forwardMovements + 1
	elseif startCounter == 2 then
		moveForward(4)
		startCounter = startCounter + 1
		forwardMovements = forwardMovements + 4
	elseif startCounter == 3 then
		moveForward(2)
		startCounter = startCounter + 1
		forwardMovements = forwardMovements + 2
	elseif startCounter == 4 then
		print("do nothing")
		startCounter = startCounter + 1
	elseif startCounter == 5 then
		moveForward(3)
		startCounter = 1
		forwardMovements = forwardMovements + 3
	end
	
	local rowCnt = forwardMovements + 1
	while rowCnt <= squareRows do
		local depthCount = 0
		while (canGoDown()) do
			checkFuel()
			depthCount = depthCount + 1
			digDown()
			mineOres()
			if turtle.getItemCount(16) > 0 then
				transferItems()
			end
		end
		
		print("at bedrock, going back to surface")
		checkFuel()
		riseUp(depthCount)
		checkFuel()
		
		if (rowCnt + 5) <= squareRows then
			moveForward(5)
			rowCnt = rowCnt + 5
			forwardMovements = forwardMovements + 5
		else
			print("reached end of column")
			turnAround()
			moveForward(forwardMovements)
			turnAround()
			if columnCnt + 1 <= squareColumns then
				turtle.turnRight()
				moveForward(1)
				turtle.turnLeft()
			end
			break
		end
	end
end

goHome(0, squareColumns-1)