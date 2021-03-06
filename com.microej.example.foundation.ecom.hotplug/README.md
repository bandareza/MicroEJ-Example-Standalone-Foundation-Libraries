# Overview
This example shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.

# Usage
## Run on device
Note that this must not be a virtual device
### Build
1. Right Click on [ExampleHotPlug.java](src/main/java/com/microej/example/foundation/ecom/hotplug/ExampleHotPlug.java)
1. Select **Run as -> Run Configuration**
1. Select **MicroEJ Application** configuration kind
1. Click on **New launch configuration** icon
1. In **Execution** tab
	1. In **Target** frame, in **Platform** field, select a relevant platform (but not a virtual device)
	1. In **Execution** frame
		1. Select **Execute on Device**
		2. In **Settings** field, select **Build & Deploy** 
1. In **Configuration** tab
	* Go to **Libraries -> ECOM -> Comm Connection**
		* Check **Enable comm connections**
		* Map the UART com port (available on your platform documentation) to the application port `42`
	* Go to **Target  -> Deploy -> Means**
		* Put No deployment
1. Press **Apply**
1. Press **Run**
1. Copy the generated `.out` file path shown by the console

### Flash
1. Use the appropriate MicroEJ tool.

# Requirements
* MicroEJ Studio or SDK 4.0 or later
* A platform with at least:
	* EDC-1.2 or higher
	* ECOM-1.1 or higher
	* ECOM-COMM-1.1 or higher


## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.

# Source
N/A

# Restrictions
None.

