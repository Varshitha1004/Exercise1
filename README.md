# Exercise1
# Behavioural design pattern
1) Weather Monitoring System using Observer Pattern
Description:
This project demonstrates the implementation of the Observer Design Pattern. The system simulates a weather station that broadcasts temperature updates to different display units, such as in a lobby or office. The display units (Observers) automatically update when the weather station (Subject) changes its temperature.

Components:
Observer Interface: Defines the update(float temperature) method that all observers must implement to receive updates from the subject.
Subject Interface: Defines methods for registering, removing, and notifying observers.
WeatherStation Class (Subject): Implements the subject interface. Maintains a list of observers and notifies them when the temperature changes.
DisplayUnit Class (Observer): Implements the observer interface. Each display unit is notified when the temperature is updated.
Main Class: Demonstrates the working of the system. The weather station updates the temperature, and all registered observers receive the updates.
How It Works:
Register Observers: The weather station registers different display units (e.g., Lobby and Office).
Update Temperature: When the temperature changes, the weather station notifies all registered observers.
Remove Observers: Display units can be removed from the list of observers if they no longer need updates.
Usage:
Compile and run the Main class.
Observe that when the temperature is updated in the weather station, all registered display units show the updated temperature.
After removing an observer, that display unit will no longer receive updates.



2)Image Compression using Strategy Pattern
Description:
This project demonstrates the implementation of the Strategy Design Pattern. The system simulates an image storage application that can compress images using different compression algorithms (JPEG, PNG). The compression strategy can be changed at runtime.

Components:
Compressor Interface: Defines the compress(String fileName) method that all compression algorithms must implement.
JPEGCompressor Class: Implements the Compressor interface to compress an image using JPEG format.
PNGCompressor Class: Implements the Compressor interface to compress an image using PNG format.
ImageStorage Class: Stores the image using the specified compression strategy. The strategy can be changed dynamically.
Mains Class: Demonstrates the working of the system. It shows how images can be compressed using different strategies.
How It Works:
Set Compression Strategy: The ImageStorage class accepts a Compressor object (either JPEG or PNG) and uses it to compress the image.
Dynamic Strategy Change: The compression strategy can be changed at runtime, allowing different images to be compressed using different formats.
Compress Image: Once the strategy is set, the system compresses the given image using the selected algorithm.


# creational design pattern
Pattern Demonstrated: 
Builder Pattern

Overview: This project employs the Builder Pattern to allow for the step-by-step construction of customizable PC configurations. This modular approach helps manage the complexity involved in assembling PCs with different specifications and component combinations.

AllPatternsDemo

Patterns Demonstrated:
1)Singleton Pattern
2)Factory Method Pattern
Overview: This application integrates multiple design patterns into a single demo. The Singleton pattern manages a simulated database connection to ensure only one connection instance is created. The Factory Method pattern is used to create different types of notification objects dynamically


# Structural design pattern
Structural Design Patterns

1. Adapter Design Pattern
The Adapter Design Pattern is used when we need to convert one interface to another that a client expects. This allows two incompatible interfaces to work together. It acts as a bridge between the existing code and a new requirement.

Key Classes:
- IWeatherService: The target interface expected by the client.
- WeatherServiceA: A weather service that directly implements IWeatherService.
- WeatherServiceB: A service that returns weather data in XML format.
- WeatherServiceBAdapter: An adapter that adapts WeatherServiceB to IWeatherService.
- DesignPatternDemo: The main class to demonstrate the Adapter pattern.

 2. Facade Design Pattern
The Facade Design Pattern provides a simplified interface to a complex subsystem, making it easier to use. It allows us to interact with a set of classes via a unified interface.

 Key Classes:
- InventoryService: Subsystem responsible for checking stock.
- PaymentService: Subsystem responsible for processing payments.
- ShippingService: Subsystem responsible for shipping items.
- OrderFacade: The facade class that simplifies interactions with the subsystems.
- DesignPatternDemo: The main class to demonstrate the Facade pattern.
