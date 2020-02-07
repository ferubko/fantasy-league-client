package com.learn.fantasy.service;

import com.learn.fantasy.dto.fullinfo.FullInfo;
import com.learn.fantasy.exception.InternalServiceInvocationException;
import com.learn.fantasy.vo.TransferSynchResultVO;

import java.util.List;

public interface SynchronizeService {

    TransferSynchResultVO collectActualPlayerInformation() throws InternalServiceInvocationException;

    int executeSyncMissingData();

    int executeSyncExistingData();

    int synchronizeTransfers(TransferSynchResultVO transferSynchResultVO) throws InternalServiceInvocationException;

    int synchronizeMissedPlayers(TransferSynchResultVO transferSynchResultVO) throws InternalServiceInvocationException;

    int synchronizePlayerInformation(FullInfo fullInformation, List<Long> playerIds) throws InternalServiceInvocationException;

}
