#!/bin/bash

# Banana Client - Gradle Wrapper Bootstrap Script
# This script initializes the Gradle wrapper JAR file

echo "🍌 Banana Client - Gradle Wrapper Bootstrap"
echo "=========================================="
echo ""

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Error: Java is not installed or not in PATH"
    echo "Please install Java 17 or higher"
    exit 1
fi

echo "✅ Java found: $(java -version 2>&1 | head -n 1)"
echo ""

# Create gradle wrapper directory
mkdir -p gradle/wrapper

echo "📥 Downloading Gradle 8.3 wrapper JAR..."
echo ""

# Download gradle distribution
cd gradle/wrapper
if command -v curl &> /dev/null; then
    curl -L -o gradle-8.3-bin.zip https://services.gradle.org/distributions/gradle-8.3-bin.zip
elif command -v wget &> /dev/null; then
    wget -O gradle-8.3-bin.zip https://services.gradle.org/distributions/gradle-8.3-bin.zip
else
    echo "❌ Error: Neither curl nor wget found. Please download manually from:"
    echo "https://services.gradle.org/distributions/gradle-8.3-bin.zip"
    echo "Extract it and copy gradle-8.3/lib/plugins/gradle-wrapper-8.3.jar to gradle/wrapper/gradle-wrapper.jar"
    exit 1
fi

echo ""
echo "📦 Extracting wrapper JAR..."

# Extract the wrapper JAR
if command -v unzip &> /dev/null; then
    unzip -q gradle-8.3-bin.zip
    cp gradle-8.3/lib/plugins/gradle-wrapper-8.3.jar gradle-wrapper.jar
    rm -rf gradle-8.3 gradle-8.3-bin.zip
elif command -v tar &> /dev/null; then
    unzip -q gradle-8.3-bin.zip 2>/dev/null || tar -xzf gradle-8.3-bin.zip
    cp gradle-8.3/lib/plugins/gradle-wrapper-8.3.jar gradle-wrapper.jar
    rm -rf gradle-8.3 gradle-8.3-bin.zip
else
    echo "❌ Error: Neither unzip nor tar found"
    exit 1
fi

cd ../..

echo ""
echo "✅ Gradle wrapper JAR successfully created!"
echo ""
echo "🚀 You can now run:"
echo "   ./gradlew build"
echo "   ./gradlew runClient"
echo "   ./gradlew test"
echo ""
echo "🍌 Happy hacking!"
