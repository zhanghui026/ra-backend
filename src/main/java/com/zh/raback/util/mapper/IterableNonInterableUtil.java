/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.zh.raback.util.mapper;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
//import org.mapstruct.ap.test.selection.qualifier.annotation.TitleTranslator;

/**
 *
 * @author Sjaak Derksen
 */
@Service
public class IterableNonInterableUtil {

    @FirstElement
    public <T> T first( List<T> in ) {
        if ( in != null && !in.isEmpty() ) {
            return in.get( 0 );
        }
        else {
            return null;
        }
    }

    @LastElement
    public <T> T last( List<T> in ) {
        if ( in != null && !in.isEmpty() ) {
            return in.get( in.size() - 1 );
        }
        else {
            return null;
        }
    }

    @JoinElement
    public String join(List<String> in) {
        if ( in != null  && !in.isEmpty()) {
            return Joiner.on(",").join(in);
        } else {
            return null;
        }
    }

    @SplitElement
    public List<String> split(String join) {
        if (StringUtils.isBlank(join)){
            return null;
        } else {
            return Splitter.on(",").splitToList(join);
        }
    }

}
