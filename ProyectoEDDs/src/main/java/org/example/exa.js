import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, ScrollView, ImageBackground, FlatList, Alert, Platform } from 'react-native';
import React, {useState, useEffect} from 'react'
import { Button } from 'react-native-web';

const BackgroundImage = require('./assets/westernBacon.jpg')



export default function App() {

    const mostrarPedido = (item) => {
        if (Platform.OS === 'web') {
            const confirmation = window.confirm(`Confirmar orden: ${item.nombre} - ${item.precio}`);
        } else {
            Alert.alert(
                'Confirmar orden',
                `${item.nombre} - ${item.precio}`,
                [
                    {
                        text: 'Cancelar',
                        onPress: () => console.log('Cancel Pressed'),
                        style: 'cancel',
                    },
                    { text: 'Confirmar', onPress: () => console.log('OK Pressed') },
                ],
                { cancelable: false }
            );
        }
    };

    const platosPrincipales = [
        { id: '1', nombre: 'Western Bacon', descripcion: 'La mejor burger, carne, tocino, bbq y cebolla empanizada', precio: '$200', },
        { id: '2', nombre: 'Hamburgesa sencilla', descripcion: 'La normalona con carne, queso y vegetales', precio: '$120', },
        { id: '3', nombre: 'Fish', descripcion: 'Hamburgesa con mayonesa y filete de pescado empanizado', precio: '$150', },
        { id: '4', nombre: 'Double western bacon', descripcion: 'Western Bacon pero con 2 carnes', precio: '$260', },
        { id: '5', nombre: 'Sencilla con black angus', descripcion: 'Hamburgesa sencilla con carne Black Angus', precio: '$300', }
    ]

    const bebidas = [
        { id: '1', nombre: 'Coca Cola', descripcion: 'Coquita de toda la vida', precio: '$15', },
        { id: '2', nombre: '7up', descripcion: 'Refresco de lima-limon sin azucar', precio: '$15', },
        { id: '3', nombre: 'Agua de jamaica', descripcion: 'Awita de jamaica', precio: '$10', },
        { id: '4', nombre: 'Agua de horchata', descripcion: 'agua de arroz', precio: '$10', },
        { id: '5', nombre: 'Agua sencilla', descripcion: 'agua de toda la vida, no ocupa presentación', precio: '$5', }
    ]


    const renderItem = ({ item }) => (
        <View>
            <Text style={styles.titulo}>{item.nombre}</Text>
            <br/>
            <Text style={styles.descripcion}>{item.descripcion}</Text>
            <br/>
            <Text style={styles.precio}>{item.precio}</Text>
            <br/>
            <Button color='red' title='Ordenar' onPress={() => mostrarPedido(item)}/>
            <br/>
        </View>
    )

    return (
        <ImageBackground
            source={BackgroundImage}
            style={styles.background}
            resizeMode='cover'
        >
            <View style={styles.ViewTituloDescripcion}>
                <Text style={styles.mainText}>
                    Bienvenido al restaurande Cardenales UPQ
                </Text>
                <br/>
                <Text style={styles.descripcionText}>
                    El mejor restaurante de toda la UPQ
                </Text>
            </View>
            <ScrollView style={styles.scrollViewBody}>
                <Text style={styles.subtitulo}>
                    Platillos principales:
                </Text>
                <br/>
                <FlatList
                    data={platosPrincipales}
                    renderItem={renderItem}
                    keyExtractor={item => item.id}
                    ItemSeparatorComponent={() => <View style={styles.separador} />}
                />
                <br/>
                <Text style={styles.subtitulo}>
                    Bebidas:
                </Text>
                <br/>
                <FlatList
                    data={bebidas}
                    renderItem={renderItem}
                    keyExtractor={item => item.id}
                    ItemSeparatorComponent={() => <View style={styles.separador} />}
                />
            </ScrollView>

        </ImageBackground>
    );
}

const styles = StyleSheet.create({

    scrollViewBody: {
        width: '90%',
        height: '65%'
    },
    botonsito: {
        color: 'white'
    },
    background: {
        flex: 1,
        width: '100%',
        height: '100%',
        justifyContent: 'center',
        alignItems: 'center'
    },
    ViewTituloDescripcion: {
        flex: 1,
        padding: '15px',
        justifyContent: 'flex-start',
        alignItems: 'center',
    },
    mainText: {
        fontSize: 24,
        fontWeight: 'bold',
        color: '#000000ff',
        backgroundColor: '#ffffffff',
        borderRadius: '5px'
    },
    descripcionText: {
        fontSize: 24,
        fontWeight: 'bold',
        color: '#000000ff',
        backgroundColor: '#ffffffff',
        borderRadius: '5px'
    },
    subtitulo: {
        fontSize: 25,
        fontWeight: 'bold',
        color: '#000000ff',
        backgroundColor: '#ffffffff',
        borderRadius: '5px',
    },
    titulo: {
        fontSize: 18,
        fontWeight: 'bold',
        color: '#000000ff',
        backgroundColor: '#ffffffff',
        marginBottom: 5,
    },

    descripcion: {
        fontSize: 14,
        color: '#000000ff',
        backgroundColor: '#ffffffff',
    },
    precio: {
        fontSize: 14,
        color: '#000000ff',
        backgroundColor: '#ffffffff',
    },
    separador: {
        height: 1, // 1 pixel de altura
        backgroundColor: '#ddd', // Gris claro
        marginHorizontal: 10,
        marginVertical: 10,
    },

    //dsdadasdaas
});
