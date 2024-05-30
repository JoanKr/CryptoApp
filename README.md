# CryptoApp

CryptoApp is an Android application that displays cryptocurrency prices. The app uses Retrofit for networking, Moshi for JSON parsing, Room for local database storage, and supports filtering of cryptocurrencies.

## Features

- Display a list of cryptocurrency prices
- Fetch all available cryptocurrencies from CoinGecko API
- Save and remove cryptocurrencies to/from local database
- Filter cryptocurrencies by name

## Screenshot

![CryptoApp Screenshot](./CryptoApp.png)

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/cryptoapp.git
    ```
2. Open the project in Android Studio.
3. Build the project to download all the dependencies.

## Usage

1. Run the app on an emulator or a physical device.
2. Use the search bar to filter cryptocurrencies by name.
3. Tap on a cryptocurrency to save or remove it from the local database.

## API Key

This project uses the CoinGecko API. To use the API, you need to set up an API key:

1. Go to [CoinGecko](https://www.coingecko.com/) and sign up for an API key.
2. Add the API key to your `local.properties` file:
    ```properties
    COINGECKO_API_KEY=your_api_key_here
    ```

## Dependencies

- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Android and Java.
- [Room](https://developer.android.com/jetpack/androidx/releases/room) - A persistence library that provides an abstraction layer over SQLite.
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) - A flexible view for providing a limited window into a large data set.
- [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Android lifecycle-aware components to perform actions in response to lifecycle changes.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
