package com.learn.fantasy.service;

import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.exception.InternalServiceInvocationException;

import java.util.List;

public interface SynchronizeService {

    int executeSyncMissingData() throws InternalServiceInvocationException;

    int executeSyncExistingData() throws InternalServiceInvocationException;

    int synchronizeTransfers(FullInfo fullInformation, List<Long> playerIds) throws InternalServiceInvocationException;

    int synchronizeMissedPlayers(FullInfo fullInformation, List<Long> playerIds) throws InternalServiceInvocationException;

    int synchronizePlayerInformation(FullInfo fullInformation, List<Long> playerIds) throws InternalServiceInvocationException;

}
